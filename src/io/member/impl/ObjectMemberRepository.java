package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-obj.dat";

    @Override
    public void add(Member member) {
        List<Member> members = findAll();
        members.add(member);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(members);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            Object findObject = ois.readObject();
            List<Member> list = (List<Member>) findObject;
            return list;
        }catch(FileNotFoundException e){
            return new ArrayList<>();
        }catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
