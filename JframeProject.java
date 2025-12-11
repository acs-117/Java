import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

// ===================== ELECTRICITY BILL PANEL =====================
class ElectricityBillPanel extends JPanel {
    JTextField tfNo, tfName, tfPrev, tfCurr, tfType;
    JTextArea taResult;

    ElectricityBillPanel() {
        setLayout(new GridLayout(7, 2, 5, 5));
        tfNo = new JTextField();
        tfName = new JTextField();
        tfPrev = new JTextField();
        tfCurr = new JTextField();
        tfType = new JTextField();
        taResult = new JTextArea(5, 20);
        JButton btnCalc = new JButton("Calculate Bill");

        add(new JLabel("Consumer No:")); add(tfNo);
        add(new JLabel("Consumer Name:")); add(tfName);
        add(new JLabel("Previous Reading:")); add(tfPrev);
        add(new JLabel("Current Reading:")); add(tfCurr);
        add(new JLabel("Connection Type:")); add(tfType);
        add(btnCalc); add(new JLabel());
        add(new JScrollPane(taResult));

        btnCalc.addActionListener(e -> {
            try {
                int consumerNo = Integer.parseInt(tfNo.getText());
                String name = tfName.getText();
                int prev = Integer.parseInt(tfPrev.getText());
                int curr = Integer.parseInt(tfCurr.getText());
                String type = tfType.getText();

                int units = curr - prev;
                double amount = 0;
                if (type.equalsIgnoreCase("domestic")) {
                    if (units <= 100) amount = units * 1;
                    else if (units <= 200) amount = 100 * 1 + (units - 100) * 2.5;
                    else if (units <= 500) amount = 100 * 1 + 100 * 2.5 + (units - 200) * 4;
                    else amount = 100 * 1 + 100 * 2.5 + 300 * 4 + (units - 500) * 6;
                } else {
                    if (units <= 100) amount = units * 2;
                    else if (units <= 200) amount = 100 * 2 + (units - 100) * 4.5;
                    else if (units <= 500) amount = 100 * 2 + 100 * 4.5 + (units - 200) * 6;
                    else amount = 100 * 2 + 100 * 4.5 + 300 * 6 + (units - 500) * 7;
                }

                taResult.setText("----- ELECTRICITY BILL -----\n"
                        + "Consumer No: " + consumerNo + "\n"
                        + "Consumer Name: " + name + "\n"
                        + "Connection Type: " + type + "\n"
                        + "Previous Reading: " + prev + "\n"
                        + "Current Reading: " + curr + "\n"
                        + "Units Consumed: " + units + "\n"
                        + "Bill Amount: " + amount);
            } catch (Exception ex) {
                taResult.setText("Please enter valid input!");
            }
        });
    }
}

// ===================== EMPLOYEE PANEL =====================
class EmployeePanel extends JPanel {
    JTextField tfName, tfId, tfAddr, tfMail, tfMob, tfBasic;
    JComboBox<String> cbDesignation;
    JTextArea taResult;
    JButton btnGenerate;

    EmployeePanel() {
        setLayout(new GridLayout(9, 2, 5, 5));
        tfName = new JTextField();
        tfId = new JTextField();
        tfAddr = new JTextField();
        tfMail = new JTextField();
        tfMob = new JTextField();
        tfBasic = new JTextField();
        cbDesignation = new JComboBox<>(new String[]{"Assistant Professor", "Associate Professor", "Professor"});
        taResult = new JTextArea(8, 20);
        btnGenerate = new JButton("Generate PaySlip");

        add(new JLabel("Name:")); add(tfName);
        add(new JLabel("ID:")); add(tfId);
        add(new JLabel("Address:")); add(tfAddr);
        add(new JLabel("Mail ID:")); add(tfMail);
        add(new JLabel("Mobile No:")); add(tfMob);
        add(new JLabel("Basic Pay:")); add(tfBasic);
        add(new JLabel("Designation:")); add(cbDesignation);
        add(btnGenerate); add(new JScrollPane(taResult));

        btnGenerate.addActionListener(e -> {
            try {
                String name = tfName.getText();
                String id = tfId.getText();
                String addr = tfAddr.getText();
                String mail = tfMail.getText();
                long mob = Long.parseLong(tfMob.getText());
                double bp = Double.parseDouble(tfBasic.getText());
                String desig = (String) cbDesignation.getSelectedItem();

                double DA=0, HRA=0.1*bp;
                if(desig.equals("Assistant Professor")) DA=0.6*bp;
                else if(desig.equals("Associate Professor")) DA=0.7*bp;
                else DA=0.97*bp;
                double PF=0.12*bp;
                double SCF=0.001*bp;
                double gross=bp+DA+HRA;
                double net=gross-(PF+SCF);

                taResult.setText("Employee: " + name + "\nID: " + id + "\nAddress: " + addr +
                        "\nMail: " + mail + "\nMobile: " + mob +
                        "\nDesignation: " + desig +
                        "\nGross Salary: " + gross + "\nNet Salary: " + net);
            } catch(Exception ex) {
                taResult.setText("Please enter valid input!");
            }
        });
    }
}

// ===================== SHAPE PANEL =====================
class ShapePanel extends JPanel {
    JTextField tf1, tf2;
    JButton btnRect, btnTri, btnCircle;
    JTextArea taResult;

    ShapePanel() {
        setLayout(new GridLayout(5, 2, 5, 5));
        tf1 = new JTextField();
        tf2 = new JTextField();
        taResult = new JTextArea(5, 20);
        btnRect = new JButton("Rectangle Area");
        btnTri = new JButton("Triangle Area");
        btnCircle = new JButton("Circle Area");

        add(new JLabel("Value 1:")); add(tf1);
        add(new JLabel("Value 2:")); add(tf2);
        add(btnRect); add(btnTri);
        add(btnCircle); add(new JLabel());
        add(new JScrollPane(taResult));

        btnRect.addActionListener(e -> {
            try {
                int l = Integer.parseInt(tf1.getText());
                int b = Integer.parseInt(tf2.getText());
                taResult.setText("Rectangle Area = " + (l * b));
            } catch(Exception ex){ taResult.setText("Enter valid integers"); }
        });

        btnTri.addActionListener(e -> {
            try {
                int base = Integer.parseInt(tf1.getText());
                int height = Integer.parseInt(tf2.getText());
                taResult.setText("Triangle Area = " + (0.5 * base * height));
            } catch(Exception ex){ taResult.setText("Enter valid integers"); }
        });

        btnCircle.addActionListener(e -> {
            try {
                int r = Integer.parseInt(tf1.getText());
                taResult.setText("Circle Area = " + (3.14 * r * r));
            } catch(Exception ex){ taResult.setText("Enter valid integer"); }
        });
    }
}

// ===================== FINALLY PANEL =====================
class FinallyPanel extends JPanel {
    JTextArea taResult;
    JButton btnNoExc, btnExc, btnReturn;

    FinallyPanel() {
        setLayout(new BorderLayout());
        JPanel btnPanel = new JPanel();
        taResult = new JTextArea(10, 30);
        btnNoExc = new JButton("No Exception");
        btnExc = new JButton("With Exception");
        btnReturn = new JButton("Return Statement");

        btnPanel.add(btnNoExc); btnPanel.add(btnExc); btnPanel.add(btnReturn);
        add(btnPanel, BorderLayout.NORTH); add(new JScrollPane(taResult), BorderLayout.CENTER);

        btnNoExc.addActionListener(e -> {
            try { taResult.append("No Exception Try\n"); } 
            catch(Exception e1){ taResult.append("No Exception Catch\n"); } 
            finally{ taResult.append("No Exception Finally\n\n"); }
        });

        btnExc.addActionListener(e -> {
            try { taResult.append("Exception Try\n"); int a=10/0; } 
            catch(Exception e1){ taResult.append("Exception Caught\n"); } 
            finally{ taResult.append("Exception Finally\n\n"); }
        });

        btnReturn.addActionListener(e -> {
            try { taResult.append("Return Try\n"); return; } 
            finally{ taResult.append("Return Finally\n\n"); }
        });
    }
}

// ===================== JOB APPLICATION PANEL =====================
class JobApplicationPanel extends JPanel {
    JTextField tfName, tfRole, tfAge;
    JTextArea taResult;
    JButton btnSubmit;

    JobApplicationPanel() {
        setLayout(new GridLayout(4,2,5,5));
        tfName = new JTextField(); tfRole = new JTextField(); tfAge = new JTextField();
        taResult = new JTextArea(5,20);
        btnSubmit = new JButton("Submit");

        add(new JLabel("Name:")); add(tfName);
        add(new JLabel("Role:")); add(tfRole);
        add(new JLabel("Age:")); add(tfAge);
        add(btnSubmit); add(new JScrollPane(taResult));

        btnSubmit.addActionListener(e -> {
            try {
                String name=tfName.getText(), role=tfRole.getText();
                int age=Integer.parseInt(tfAge.getText());
                if(age<18) throw new Exception("Too young to apply");
                else if(age>40) throw new Exception("Too old to apply");
                else taResult.setText("Application Accepted");
            } catch(Exception ex){ taResult.setText(ex.getMessage()); }
        });
    }
}

// ===================== MOUSE EVENTS PANEL =====================
class MouseEventsPanel extends JPanel {
    JLabel lblMsg;

    MouseEventsPanel() {
        setLayout(null);
        lblMsg = new JLabel();
        lblMsg.setBounds(50,50,400,30);
        add(lblMsg);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){ lblMsg.setText("Clicked at ("+e.getX()+","+e.getY()+")"); }
            public void mouseEntered(MouseEvent e){ lblMsg.setText("Entered at ("+e.getX()+","+e.getY()+")"); }
            public void mouseExited(MouseEvent e){ lblMsg.setText("Exited at ("+e.getX()+","+e.getY()+")"); }
            public void mousePressed(MouseEvent e){ lblMsg.setText("Pressed at ("+e.getX()+","+e.getY()+")"); }
            public void mouseReleased(MouseEvent e){ lblMsg.setText("Released at ("+e.getX()+","+e.getY()+")"); }
        });
    }
}

// ===================== MULTI-THREAD PANEL =====================
class MultiThreadPanel extends JPanel {
    JTextField tfCount; JTextArea taResult; JButton btnStart;

    MultiThreadPanel() {
        setLayout(new BorderLayout());
        JPanel top=new JPanel();
        tfCount=new JTextField(5); btnStart=new JButton("Start");
        top.add(new JLabel("Number of random numbers:")); top.add(tfCount); top.add(btnStart);
        taResult=new JTextArea(15,30);
        add(top,BorderLayout.NORTH); add(new JScrollPane(taResult),BorderLayout.CENTER);

        btnStart.addActionListener(e -> {
            int count=Integer.parseInt(tfCount.getText());
            new Thread(()->{
                Random r=new Random();
                for(int i=0;i<count;i++){
                    int n=r.nextInt(100);
                    SwingUtilities.invokeLater(()->taResult.append("Generated: "+n+"\n"));
                    if(n%2==0) SwingUtilities.invokeLater(()->taResult.append("Square: "+(n*n)+"\n"));
                    else SwingUtilities.invokeLater(()->taResult.append("Cube: "+(n*n*n)+"\n"));
                    try{ Thread.sleep(1000); }catch(Exception ex){}
                }
            }).start();
        });
    }
}

// ===================== PRODUCER-CONSUMER PANEL =====================
class ProducerConsumerPanel extends JPanel {
    JTextField tfItems, tfProdDelay, tfConsDelay; JTextArea taResult; JButton btnStart;

    ProducerConsumerPanel() {
        setLayout(new BorderLayout());
        JPanel top=new JPanel();
        tfItems=new JTextField(5); tfProdDelay=new JTextField(5); tfConsDelay=new JTextField(5);
        btnStart=new JButton("Start");
        top.add(new JLabel("Items:")); top.add(tfItems);
        top.add(new JLabel("Producer Delay(ms):")); top.add(tfProdDelay);
        top.add(new JLabel("Consumer Delay(ms):")); top.add(tfConsDelay);
        top.add(btnStart);
        taResult=new JTextArea(15,30);
        add(top,BorderLayout.NORTH); add(new JScrollPane(taResult),BorderLayout.CENTER);

        btnStart.addActionListener(e -> {
            int items=Integer.parseInt(tfItems.getText());
            int prodDelay=Integer.parseInt(tfProdDelay.getText());
            int consDelay=Integer.parseInt(tfConsDelay.getText());
            Q q=new Q(items,taResult,prodDelay,consDelay); q.startThreads();
        });
    }

    static class Q{
        int data; boolean available=false; int items; JTextArea ta; int prodDelay,consDelay;
        Q(int items,JTextArea ta,int prodDelay,int consDelay){this.items=items; this.ta=ta; this.prodDelay=prodDelay; this.consDelay=consDelay;}
        synchronized void put(int value){ while(available){try{wait();}catch(Exception e){}}
            data=value; SwingUtilities.invokeLater(()->ta.append("Produced: "+data+"\n")); available=true; notify(); }
        synchronized int get(){ while(!available){try{wait();}catch(Exception e){}}
            int val=data; SwingUtilities.invokeLater(()->ta.append("Consumed: "+val+"\n")); available=false; notify(); return val;}
        void startThreads(){
            new Thread(()->{for(int i=0;i<items;i++){put(i); try{Thread.sleep(prodDelay);}catch(Exception e){}}}).start();
            new Thread(()->{for(int i=0;i<items;i++){get(); try{Thread.sleep(consDelay);}catch(Exception e){}}}).start();
        }
    }
}

// ===================== MAIN FRAME =====================
public class JframeProject extends JFrame {
    public JframeProject(){
        setTitle("All Programs in One JFrame"); setSize(800,600); setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTabbedPane tabs=new JTabbedPane();
        tabs.add("Electricity Bill", new ElectricityBillPanel());
        tabs.add("Employee", new EmployeePanel());
        tabs.add("Shape", new ShapePanel());
        tabs.add("Finally", new FinallyPanel());
        tabs.add("Job Application", new JobApplicationPanel());
        tabs.add("Mouse Events", new MouseEventsPanel());
        tabs.add("Multi-Thread", new MultiThreadPanel());
        tabs.add("Producer-Consumer", new ProducerConsumerPanel());
        add(tabs); setVisible(true);
    }
    public static void main(String[] args){ new JframeProject(); }
}