package network.tcp.autocloseable;

public class ResourceCloseMainV2 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try{
            resource1 = new ResourceV1("resource1"); // 만약 이 부분에서 에러 발생 시 resource2가 null인 상태로 finally 에서 자원 정리가 되어 null exception 발생
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx(); // CallException
        }catch(CallException e){
            System.out.println("ex : " + e);
            throw e;
        }finally {
            if(resource2 != null){
                resource2.closeEx(); // CloseException 발생
            }
            if(resource1 != null){
                resource1.closeEx();  // 이 코드 호출 안됨!
            }
        }

    }
}
