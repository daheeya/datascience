package ch28;

public class Req<T> {
    private Header header;
    private T reqBody;
    public static class Header{
        private String responseCode;

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public T getReqBody() {
        return reqBody;
    }

    public void setReqBody(T reqBody) {
        this.reqBody = reqBody;
    }
}

class User{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Main__{
    public static void main(String[] args) {
        var req = new Req<User>();

        var header = new Req.Header(); // 헤더 클래스 생성
        header.setResponseCode("200 OK");

        req.setHeader(header);
        req.setReqBody(req.getReqBody());
    }
}