package vicky.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import vicky.test.model.Address;
import vicky.test.model.MyPojo;
import vicky.test.model.Profile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BigJsonMain {
    private static final int NUMBER_OF_TRIES=200;
    private static final int PROFILE_SIZE=100*10000;

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static void main(String[] args) throws IOException {
        MyPojo aBigJson = generateBigJson();
        File resultFile = new File("/Users/songwenqin/test.json");
        mapper.writeValue(resultFile, aBigJson);

        for(int i=0; i<NUMBER_OF_TRIES; i++) {
            MyPojo readBigJson = mapper.readValue(resultFile, MyPojo.class);
            System.out.println("Time-" + i + ":" + aBigJson.getProfile().getContactNo().equals(readBigJson.getProfile().getContactNo()));

            Profile child = new Profile();
            child.setContactNo("baby"+i);
            Address babyAddress = new Address();
            babyAddress.setState("babyState" +  i);
            babyAddress.setCity("babyCity" + i);
            babyAddress.setZip("babyZip" + i);
            child.setAddress(babyAddress);
            readBigJson.getProfile().getChildren().add(child);
            mapper.writeValue(resultFile, readBigJson);

        }


    }

    private static MyPojo generateBigJson() {
        MyPojo myPojo = new MyPojo();
        Profile profile = new Profile();
        profile.setContactNo("contact-0");
        Address address0 = new Address();
        address0.setCity("city0");
        address0.setState("state0");
        address0.setZip("zip0");
        profile.setAddress(address0);

        List<Profile> children = new ArrayList<Profile>();
        for(int i=0; i<PROFILE_SIZE; i++){
            Profile profileI = new Profile();
            profileI.setContactNo("contact-" + i);
            Address addressI= new Address();
            addressI.setCity("city" + i);
            addressI.setState("state" + i);
            addressI.setZip("zip" + i);
            profileI.setAddress(addressI);
            children.add(profileI);
        }
        profile.setChildren(children);
        myPojo.setProfile(profile);

        return myPojo;
    }
}
