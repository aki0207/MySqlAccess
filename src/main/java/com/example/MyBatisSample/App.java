package com.example.MyBatisSample;
 
import java.io.IOException;
import java.io.Reader;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.entity.TUser;
import com.example.entity.TUserExample;
import com.example.entity.TUserMapper;
/**
 * MyBatisを使ってDBにアクセスするサンプルプログラムです.
 *
 */
public class App {
    public static void main(String[] args) {
 
        // resources直下のmybatis-config.xmlを読み込みます
        try (Reader r = Resources.getResourceAsReader("mybatis-config.xml");) {
 
            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
 
            // SQLセッションを取得します
            try (SqlSession session = factory.openSession()) {
 
                // ActorテーブルのMapperを取得します
                TUserMapper map = session.getMapper(TUserMapper.class);
 
                // Actorテーブルの条件検索用クラスを生成します
                TUserExample ex = new TUserExample();
 
                // WHERE
                //    (first_name LIKE 'T%' AND actor_id < 100)
                //    OR (last_name LIKE 'S%' AND actor_id > 100)
                // 検索条件に↑と同等の条件を設定しています
                // 　  Criteriaを作成し、AND条件を追加する (1)
//                ex.createCriteria().andUserNameLike("T%").andUserIdLessThan((short)100);
                // 2 OR条件がある場合はExampleのor() メソッドで区切り、OR条件内の条件を追加する
               // ex.or().andLastNameLike("S%").andActorIdGreaterThan((short)100);
 
                // 上記の条件でテーブルを検索します
                List<TUser> userList = map.selectByExample(ex);
 
                // 取得結果を表示します
                System.out.println("user_id, user_name");
                for (TUser user : userList) {
 
                    System.out.printf("%s, %s \n", user.getUserId(), user.getUserName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}