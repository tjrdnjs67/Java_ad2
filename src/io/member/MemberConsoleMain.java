package io.member;

import io.member.impl.DataMemberRepository;
import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;
import io.member.impl.ObjectMemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {

    //private static final MemberRepository repository = new ObjectMemberRepository();
    private static final MemberRepository repository = new FileMemberRepository();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1.회원등록 | 2.회원 목록 조회 | 3.종료");
            System.out.print("선택 : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // nextInt 시 Enter가 남아있기 때문에 없애줘야함

            switch (choice){
                case 1:
                    // 회원 등록
                    registerMember(scanner);
                    break;
                case 2:
                    // 회원 목록 조회
                    displayMembers();
                    break;
                case 3:
                    // 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }

        }
    }

    private static void registerMember(Scanner scanner) {
        System.out.print("ID 입력 : ");
        String id = scanner.nextLine();

        System.out.print("Name 입력 : ");
        String name = scanner.nextLine();

        System.out.print("Age 입력 : ");
        int age = scanner.nextInt();
        scanner.nextLine(); // newLine 제거

        Member newMember = new Member(id, name, age);
        repository.add(newMember);
    }

    private static void displayMembers() {
        List<Member> members = repository.findAll();

        for (Member member : members) {
            System.out.println(member);
        }
    }

}
