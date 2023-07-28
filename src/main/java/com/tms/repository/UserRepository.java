package com.tms.repository;
import com.tms.domain.UserInfo;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Integer, UserInfo> users = new HashMap<>();

    {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(1);
        userInfo1.setFirstName("Amir");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2);
        userInfo2.setFirstName("Abama");

        users.put(1,userInfo1);
        users.put(2,userInfo2);
    }

    public List<UserInfo> findAll(){
        return users.values().stream().toList();
    }

    public UserInfo findById(Integer id){
        return users.get(id);
    }

    public void save(UserInfo userInfo){
        users.put(userInfo.getId(),userInfo);
    }

    public void delete(Integer id){
        users.remove(id);
    }
}
