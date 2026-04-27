package train.ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import train.ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;

    private List<User> userList;

    private static final String USERS_PATH = "src/main/java/train/ticket/booking/localdb/users.json";

    private static final ObjectMapper mapper = new ObjectMapper();

    public UserBookingService(User user) {
        this.user = user;
        File users = new File(USERS_PATH);
        try {
            userList = mapper.readValue(users, new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean logInUser(){
        Optional<User> foundUser = userList.stream().filter(user -> {
            return this.user.getUsername().equals(user.getUsername());
        }).findFirst();
        return foundUser.isPresent();
    }

    public boolean signUpUser(User user){
        try {
            userList.add(user);
            File users = new File(USERS_PATH);
            mapper.writeValue(users, user);
            return true;
        }catch (IOException e){
            return false;
        }
    }


}
