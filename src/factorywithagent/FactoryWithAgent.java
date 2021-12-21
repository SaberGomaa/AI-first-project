/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorywithagent;

/**
 *
 * @author Ali Tahoon
 */
public class FactoryWithAgent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        myProjectsTools.setOpenForm(new mainForm(), "Mainform");
//        try {
//            jade.core.Runtime r = jade.core.Runtime.instance();
//            Profile p = new ProfileImpl("localhost", 9000, "mainplateform");
//            ContainerController cc = r.createMainContainer(p);
//            AgentController rma = cc.createNewAgent("rma", "jade.tools.rma.rma", null);
//            rma.start();
//            AgentController cust = cc.createNewAgent("Customer1", "agents.Customer1", null);
//            cust.start();
//            AgentController factory = cc.createNewAgent("Factory", "agents.factory", null);
//            factory.start();
//            myProjectsTools.setOpenForm(new mainForm(), "Main Form");
//        } catch (StaleProxyException ex) {
//            Logger.getLogger(FactoryWithAgent.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
