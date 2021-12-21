package agents;

import factorywithagent.mainForm;
import static factorywithagent.mainForm.price1;
import factorywithagent.myProjectsTools;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ali Tahoon
 */
public class factory extends Agent {

    private static Double prise;
    private static double p2;
    private static double p3;
    private static String checkPrise = "null";
    private static String reciever = "null";

    public static double getP2() {
        return p2;
    }

    public static void setP2(double aP2) {
        p2 = aP2;
    }

    public static double getP3() {
        return p3;
    }

    public static void setP3(double aP3) {
        p3 = aP3;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public Double getPrise() {
        return prise;
    }

    public void setPrise(Double prise) {
        this.prise = prise;
    }

    public String getCheckPrise() {
        return checkPrise;
    }

    public void setCheckPrise(String checkPrise) {
        this.checkPrise = checkPrise;
    }

    @Override
    protected void setup() {
//        addBehaviour(new OneShotBehaviour() {
//            @Override
//            public void action() {
//                factoryProjectWithAgentsController f=new factoryProjectWithAgentsController();
//                f.setTblData("orandJuse", 4.5, 6);
//            }
//        });
        System.out.println("Factory start sending massege.... ");
        ACLMessage acl = new ACLMessage();
        acl.addReceiver(new AID(getReciever(), false));
        acl.setContent("Hello " + reciever + " ...");
        acl.setPerformative(ACLMessage.INFORM);
        send(acl);
        //reseive order
        System.out.println("Hello From " + reciever);
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() throws ExceptionInInitializerError {
                if (getCheckPrise() == "Prise have changed" || getCheckPrise()=="new offer") {

                    for (int i = 1; i <= 3; i++) {
                        ACLMessage alarm = new ACLMessage();
                        alarm.setPerformative(ACLMessage.INFORM);
                        alarm.setContent("Prise changed");
                        alarm.addReceiver(new AID("customer" + i, false));
                        send(alarm);
                    }

                    //myProjectsTools.msgbooks("prise Changed");
                    setCheckPrise("null");
                }
            }
        });

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {

                ACLMessage aa = receive();
                if (aa != null) {
                    String con = aa.getContent();

                    StringTokenizer st = new StringTokenizer(con);
                    String productName = "";
                    double balance = 0;
                    int Quantity = 0;
                    while (st.hasMoreTokens()) {

                        productName = st.nextToken();

                        balance = Double.parseDouble(st.nextToken());

                        Quantity = Integer.parseInt(st.nextToken());
                    }
//                    System.out.println(productName);
//                    System.out.println(balance);
//                    System.out.println(Quantity);
                    if ("kiwi".equals(productName)) {
                        if ((Quantity * mainForm.price1) > balance) {
                            myProjectsTools.msgbooks("You don't have enough money !!!");
                        } else {
                            
                        myProjectsTools.msgbooks("Ok You will get what you order now...");
                    }
                    }
                    if ("orange".equals(productName)) {
                        if ((Quantity * mainForm.price2) > balance) {
                            myProjectsTools.msgbooks("You don't have enough money !!!");
                        } else {
                            
                        myProjectsTools.msgbooks("Ok You will get what you order now...");
                    }
                    }
                    if ("apple".equals(productName)) {
                        if ((Quantity * mainForm.price3) > balance) {
                            myProjectsTools.msgbooks("You don't have enough money !!!");
                        } else {
                            
                        myProjectsTools.msgbooks("Ok You will get what you order now...");
                    }
                    }                   
                }
            }
        
    }

);

    }
}
