package nainsy.food_api.api;

import nainsy.food_api.model.User;
import nainsy.food_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
  @Autowired
private  UserService userService;

  @GetMapping("/api/v1/users")
  public Map<String, Object> userList(){
    Map<String,Object> returnMap=new HashMap<>();

    List<User> users= userService.getUsers();
if (users!=null) {
  returnMap.put("success","true");
  returnMap.put("total",users.size());
  returnMap.put("users", users);
}else
{
  returnMap.put("success","false");
  returnMap.put("msg","No Valid UserList Received");
}
    return  returnMap;

  }

  @GetMapping("/api/v1/getuser/{id}")
    public Map<String,Object> user(@PathVariable int id)
  {
      Map<String,Object> map=new HashMap<>();
      User gotUser=userService.getUser(id);
      if (gotUser!=null)
      {
        map.put("success","true");
        map.put("user",gotUser);
      }else
      {
        map.put("success","false");
        map.put("msg","No such User exist with id "+id);
      }

      return map;

  }

  @PostMapping("/api/v1/adduser")
    public Map<String,Object> adduser(@RequestBody User user)
  {

    Map<String,Object> map=new HashMap<>();
    int returnedId= userService.addUser(user);

    if (returnedId>=1) {
      map.put("success", "true");
      map.put("msg", "User Regisetered Successfully");
      map.put("user",userService.getUser(returnedId));
    }else
    {
      map.put("success","false");
      map.put("msg","can not Register User ");
    }
    return map;
  }

}
