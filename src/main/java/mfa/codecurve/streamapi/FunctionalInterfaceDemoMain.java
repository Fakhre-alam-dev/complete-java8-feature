package mfa.codecurve.streamapi;

public class FunctionalInterfaceDemoMain {
    public static void main(String[] args) {
        FunctionalInterfaceDemo fun=(x,y)->x+y;
       Integer sum= fun.add(10,20);
        System.out.println(sum);
    }
}
