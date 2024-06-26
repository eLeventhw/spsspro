package com.ices.ruanjian;

import org.jvnet.substance.SubstanceLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//class SubstanceTest {
//
//    static void useSkin() throws Exception {
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JDialog.setDefaultLookAndFeelDecorated(true);
//
//        UIManager
//                .setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");
//    }
//
//    static void useTheme() throws Exception {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                // 此处设置皮肤和主题
//                SubstanceLookAndFeel
//                        .setCurrentTheme("org.jvnet.substance.theme.SubstanceAquaTheme");
//            }
//        });
//    }
//}
class CustomException extends Exception {
    //无参构造方法
    public CustomException(){

        super();
    }
    //有参的构造方法
    public CustomException(String message){
        super(message);

    }
    // 用指定的详细信息和原因构造一个新的异常
    public CustomException(String message, Throwable cause){

        super(message,cause);
    }
    //用指定原因构造一个新的异常
    public CustomException(Throwable cause) {

        super(cause);
    }
}

// 备注： 这些方法怎么来的？ 重写父类Exception的方法，那么如何查看Exception具有哪些API，快捷键：选中Exception, command+单击。windows系统 ：选中Exception, control+单击。

public class Finalclass {
    //    static JFrame frame = new JFrame("数学建模助手");
    static JFrame frame2 = new JFrame("数学建模助手");
    Box bBoxLeft = Box.createVerticalBox();
    static CardLayout card=new CardLayout();//卡片布局
    static CardLayout card2=new CardLayout();//卡片布局
    static int ffff=1;
    static Box bBoxCenter = Box.createVerticalBox();
    Box bBoxRight = Box.createVerticalBox();
    static JLabel methodd,methodd2;
    static JPanel cardpanel=new JPanel(card);
    static JPanel cardpanels=new JPanel(card2);
    static JPanel cardPanel1 = new JPanel();
    static JPanel cardPanel2 = new JPanel();
    static JPanel cardPanels1 = new JPanel();
    static JPanel cardPanels2 = new JPanel();
    static ArrayList<JPanel> CardPanel2 = new ArrayList<JPanel>();
    static JPanel spacer=new JPanel();
    static JLabel jlll;
    private static ImageIcon image2,image3;
    static int index=0;
    static int index2=0;
    static int cardnumber=0;
    static int filenumber=0;
    private static int width = 600, height = 400;
    static int arrlength;static String[] arr1;
    //    static JCheckBox[] chkbox;
    static ArrayList<JCheckBox> chkbox = new ArrayList<JCheckBox>();
    static int num=1;
    static String name;
    //    static String[] arr2 ;//记录点击次数
    static ArrayList<String> arr22 = new ArrayList<String>();
    static ArrayList<String> arr21 = new ArrayList<String>();//记录可能的备选元素
    static ArrayList<String> arr3 = new ArrayList<String>();//记录可能的备选元素
    static ArrayList<String> positions = new ArrayList<String>();//记录可能的备选元素
    static JTextArea jjb=new JTextArea(20,39);
    static int item=0;
    //    static String [] position;
    static  int migong=0;
    static  int special=0;
    static  int AllowedtoAdd=0;
    static int Zeroingin =0;
    static ArrayList<String> TaskListed = new ArrayList<String>();
    static JTextField jjt=new JTextField("0,0",SwingConstants.CENTER);
    static JTextField jjt2=new JTextField("3,3",SwingConstants.CENTER);
    static Stack<String> stack = new Stack<>();//记录表格，负责出栈与入栈到达撤销的效果
    static Queue<String> queue = new LinkedList<>();//记录任务清单
    static Queue<String> resultsqueue = new LinkedList<>();//记录结果缓存队列，上限为3
    static int resultnumber=0;
    static JTextField jbeibao=new JTextField(SwingConstants.CENTER);
    static String weight=null;
    static int beibao=0;
    //    static JDialog jg= new JDialog(frame2, "结果分析", true);
//    static JFrame jg= new JFrame("结果分析");
    File file,file0;
    BufferedImage image;
    MyCanvas drawArea = new MyCanvas();
    ArrayList<String> bb = new ArrayList<String>();//传参
    public class CustomListCellRenderer extends DefaultListCellRenderer {
        private final int ITEM_HEIGHT = 40; // 自定义选项的高度

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            component.setPreferredSize(new Dimension(component.getPreferredSize().width, ITEM_HEIGHT));
            return component;
        }
    }
    private class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image,0,0,null);
        }
    }
    public void init(){
        String[] listData110 = new String[]{" 任务清单"};
        JComboBox TaskList = new JComboBox(listData110);//下拉选择框
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        TaskList.setModel(comboBoxModel);
        comboBoxModel.addElement(" 任务清单"); // 设置初始值

        String[] listData111 = new String[]{" 结果缓存管理"};
        JComboBox ResultsCache = new JComboBox(listData111);//下拉选择框
        DefaultComboBoxModel<String> comboBoxModel2 = new DefaultComboBoxModel<>();
        ResultsCache.setModel(comboBoxModel2);
        comboBoxModel2.addElement(" 结果缓存管理"); // 设置初始值

        JFrame frame = new JFrame("数学建模助手");
//        frame.setSize(450,520);
//        jg.setLocation(650, 300);
//        jg.setVisible(true);
        frame.setLocation(400, 130);
        frame.setResizable(false);
        //最大的水平组件
        Box bBox = Box.createHorizontalBox();
        //bBoxLeft
        JPanel leftPanel = new JPanel();
//        leftPanel.setLayout(new BorderLayout(3,5));
        leftPanel.setPreferredSize(new Dimension(440, 500));
        String[] listData = new String[]{" 综合评价类","  优劣解距离法","  主成分分析法", "  熵值法","  CRITIC定权"};
        JComboBox EvaluateChoose = new JComboBox(listData);//下拉选择框
        EvaluateChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
            public void itemStateChanged(ItemEvent e) {
                migong=0;
                beibao=0;
                //SELECTED 此状态更改值指示项被选定
                //getStateChange()返回被影响的方式：去选择/选择
//                if (e.SELECTED == e.getStateChange()) {
                //getSelectedItem()返回当前所选项
                //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
                System.out.println("你选择了："+EvaluateChoose.getSelectedItem()+"是第"+ (EvaluateChoose.getSelectedIndex()+1)+"个选项");
                name=EvaluateChoose.getSelectedItem().toString();
                methodd.setText(name);
                if(EvaluateChoose.getSelectedItem()=="  优劣解距离法")
                    methodd2.setText("需要一组负向变量，一组正向变量");
                else if(EvaluateChoose.getSelectedItem()=="  主成分分析法")
                    methodd2.setText("需要一组多维变量");
                else if(EvaluateChoose.getSelectedItem()=="  熵值法")
                    methodd2.setText("需要一组负向变量，一组正向变量");
                else if(EvaluateChoose.getSelectedItem()=="  CRITIC定权")
                    methodd2.setText("需要一组负向变量，一组正向变量");
                if(bb.size()>2)
                    bb.set(3,name);
//                }
            }
        });
        EvaluateChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));
        EvaluateChoose.setPreferredSize(new Dimension(300,40));
//        EvaluateChoose.setFont(new Font("微软雅黑", Font.BOLD, 15));

//        listData = new String[]{" 预测类","  移动平均法", "  指数平滑法"};
//        JComboBox PredictChoose = new JComboBox(listData);//下拉选择框
//        PredictChoose.setPreferredSize(new Dimension(300,40));
//        PredictChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
//            public void itemStateChanged(ItemEvent e) {
//                migong=0;
//                //SELECTED 此状态更改值指示项被选定
//                //getStateChange()返回被影响的方式：去选择/选择
////                if (e.SELECTED == e.getStateChange()) {
//                //getSelectedItem()返回当前所选项
//                //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
//                System.out.println("你选择了："+PredictChoose.getSelectedItem()+"是第"+ (PredictChoose.getSelectedIndex()+1)+"个选项");
//                name=PredictChoose.getSelectedItem().toString();
//                methodd.setText(name);
//                if(PredictChoose.getSelectedItem()=="  移动平均法")
//                    methodd2.setText("需要一组一维变量");
//                else if(PredictChoose.getSelectedItem()=="  指数平滑法")
//                    methodd2.setText("需要一组一维变量");
//                if(bb.size()>2)
//                    bb.set(3,name);
////                }
//            }
//        });
//        PredictChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));

//        listData = new String[]{" 回归类","  线性回归","  多项式回归","  岭回归","  偏最小二乘回归"};
//        JComboBox ReturnChoose = new JComboBox(listData);//下拉选择框
//        ReturnChoose.setPreferredSize(new Dimension(300,40));
//        ReturnChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
//            public void itemStateChanged(ItemEvent e) {
//                migong=0;
//                //SELECTED 此状态更改值指示项被选定
//                //getStateChange()返回被影响的方式：去选择/选择
////                if (e.SELECTED == e.getStateChange()) {
//                //getSelectedItem()返回当前所选项
//                //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
//                System.out.println("你选择了："+ReturnChoose.getSelectedItem()+"是第"+ (ReturnChoose.getSelectedIndex()+1)+"个选项");
//                name=ReturnChoose.getSelectedItem().toString();
//                methodd.setText(name);
//                if(ReturnChoose.getSelectedItem()=="  线性回归")
//                    methodd2.setText("需要两组一维变量");
//                else if(ReturnChoose.getSelectedItem()=="  多项式回归")
//                    methodd2.setText("需要两组一维变量");
//                else if(ReturnChoose.getSelectedItem()=="  岭回归")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                else if(ReturnChoose.getSelectedItem()=="  偏最小二乘回归")
//                    methodd2.setText("需要两组可多维变量");
//                if(bb.size()>2)
//                    bb.set(3,name);
////                }
//            }
//        });
//        ReturnChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));

//        listData = new String[]{" 时间序列分析","  ARIMA模型","  单位根检验(ADF)","  BP-神经网络"};
//        JComboBox TimeSeriesChoose = new JComboBox(listData);//下拉选择框
//        TimeSeriesChoose.setPreferredSize(new Dimension(300,40));
//        TimeSeriesChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
//            public void itemStateChanged(ItemEvent e) {
//                migong=0;
//                //SELECTED 此状态更改值指示项被选定
//                //getStateChange()返回被影响的方式：去选择/选择
////                if (e.SELECTED == e.getStateChange()) {
//                //getSelectedItem()返回当前所选项
//                //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
//                System.out.println("你选择了："+TimeSeriesChoose.getSelectedItem()+"是第"+ (TimeSeriesChoose.getSelectedIndex()+1)+"个选项");
//                name=TimeSeriesChoose.getSelectedItem().toString();
//                methodd.setText(name);
//                if(TimeSeriesChoose.getSelectedItem()=="  ARIMA模型")
//                    methodd2.setText("需要一组一维变量");
//                else if(TimeSeriesChoose.getSelectedItem()=="  单位根检验(ADF)")
//                    methodd2.setText("需要一组一维变量");
//                else if(TimeSeriesChoose.getSelectedItem()=="  BP-神经网络")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                if(bb.size()>2)
//                    bb.set(3,name);
////                }
//            }
//        });
//        TimeSeriesChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));
//
//        listData = new String[]{" 机器学习分类","  决策树分类","  逻辑回归","  adaboost分类","  随机森林分类","  K近邻(KNN)分类"};
//        JComboBox MachineLearningChoose = new JComboBox(listData);//下拉选择框
//        MachineLearningChoose.setPreferredSize(new Dimension(100,40));
//        MachineLearningChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
//            public void itemStateChanged(ItemEvent e) {
//                migong=0;
//                //SELECTED 此状态更改值指示项被选定
//                //getStateChange()返回被影响的方式：去选择/选择
////                if (e.SELECTED == e.getStateChange()) {
//                //getSelectedItem()返回当前所选项
//                //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
//                System.out.println("你选择了："+MachineLearningChoose.getSelectedItem()+"是第"+ (MachineLearningChoose.getSelectedIndex()+1)+"个选项");
//                name=MachineLearningChoose.getSelectedItem().toString();
//                methodd.setText(name);
//                if(MachineLearningChoose.getSelectedItem()=="  决策树分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                else if(MachineLearningChoose.getSelectedItem()=="  逻辑回归")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                else if(MachineLearningChoose.getSelectedItem()=="  adaboost分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                else if(MachineLearningChoose.getSelectedItem()=="  随机森林分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                else if(MachineLearningChoose.getSelectedItem()=="  K近邻(KNN)分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                if(bb.size()>2)
//                    bb.set(3,name);
////                }
//            }
//        });
//        MachineLearningChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));

        listData = new String[]{" 数据处理","  样本均衡"};
        JComboBox DataProcessingChoose = new JComboBox(listData);//下拉选择框
        DataProcessingChoose.setPreferredSize(new Dimension(300,50));
        DataProcessingChoose.setRenderer(new CustomListCellRenderer()); // 设置自定义渲染器
        DataProcessingChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if(AllowedtoAdd==1){
//                        TaskListed.add(GraphtheoryChoose.getSelectedItem().toString());
                        TaskList.addItem(DataProcessingChoose.getSelectedItem().toString());
                        queue.add(DataProcessingChoose.getSelectedItem().toString());
                    }
                    migong = 0;beibao=0;
                    //SELECTED 此状态更改值指示项被选定
                    //getStateChange()返回被影响的方式：去选择/选择
//                if (e.SELECTED == e.getStateChange()) {
                    //getSelectedItem()返回当前所选项
                    //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
                    System.out.println("你选择了：" + DataProcessingChoose.getSelectedItem() + "是第" + (DataProcessingChoose.getSelectedIndex() + 1) + "个选项");
                    name = DataProcessingChoose.getSelectedItem().toString();
                    methodd.setText(name);
                    if (DataProcessingChoose.getSelectedItem() == "  样本均衡")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    else if (DataProcessingChoose.getSelectedItem() == "  数据标准化")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    else if (DataProcessingChoose.getSelectedItem() == "  数据统计特征描述")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    else if (DataProcessingChoose.getSelectedItem() == "  频数柱状图") {
                        methodd2.setText("需要一组一维变量");
                        special = 1;
                    } else if (DataProcessingChoose.getSelectedItem() == "  频数扇形图") {
                        methodd2.setText("需要一组一维变量");
                        special = 1;
                    } else if (DataProcessingChoose.getSelectedItem() == "  简单散点图") {
                        methodd2.setText("需要两组一维变量");
                        special = 1;
                    } else if (DataProcessingChoose.getSelectedItem() == "  皮尔逊热力图") {
                        methodd2.setText("需要一维多维变量");
                        special = 1;
                    }
//                else if(DataProcessingChoose.getSelectedItem()=="  随机森林分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                else if(DataProcessingChoose.getSelectedItem()=="  K近邻(KNN)分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
                    if (bb.size() > 2)
                        bb.set(3, name);
//                }
                }
            }
        });
        DataProcessingChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));

        listData = new String[]{" 图形化处理", "  频数柱状图", "  频数扇形图", "  简单散点图", "  皮尔逊热力图"};
        JComboBox PictureProcessingChoose = new JComboBox(listData);//下拉选择框
        PictureProcessingChoose.setPreferredSize(new Dimension(300,50));
        PictureProcessingChoose.setRenderer(new CustomListCellRenderer()); // 设置自定义渲染器
        PictureProcessingChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if(AllowedtoAdd==1){
//                        TaskListed.add(GraphtheoryChoose.getSelectedItem().toString());
                        TaskList.addItem(PictureProcessingChoose.getSelectedItem().toString());
                        queue.add(PictureProcessingChoose.getSelectedItem().toString());
                    }
                    migong = 0;beibao=0;
                    //SELECTED 此状态更改值指示项被选定
                    //getStateChange()返回被影响的方式：去选择/选择
//                if (e.SELECTED == e.getStateChange()) {
                    //getSelectedItem()返回当前所选项
                    //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
                    System.out.println("你选择了：" + PictureProcessingChoose.getSelectedItem() + "是第" + (PictureProcessingChoose.getSelectedIndex() + 1) + "个选项");
                    name = PictureProcessingChoose.getSelectedItem().toString();
                    methodd.setText(name);
                    if (PictureProcessingChoose.getSelectedItem() == "  频数柱状图") {
                        methodd2.setText("需要一组一维变量");
                        special = 1;
                    } else if (PictureProcessingChoose.getSelectedItem() == "  频数扇形图") {
                        methodd2.setText("需要一组一维变量");
                        special = 1;
                    } else if (PictureProcessingChoose.getSelectedItem() == "  简单散点图") {
                        methodd2.setText("需要两组一维变量");
                        special = 1;
                    } else if (PictureProcessingChoose.getSelectedItem() == "  皮尔逊热力图") {
                        methodd2.setText("需要一维多维变量");
                        special = 1;
                    }
//                else if(DataProcessingChoose.getSelectedItem()=="  随机森林分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                else if(DataProcessingChoose.getSelectedItem()=="  K近邻(KNN)分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
                    if (bb.size() > 2)
                        bb.set(3, name);
//                }
                }
            }
        });
        PictureProcessingChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));

        listData = new String[]{" 图论与组合优化问题","  TSP","  完全背包","  0-1背包","  指派问题", "  约瑟夫问题","  迷宫问题", "  迪杰斯特拉算法","  最小生成树算法"};
        JComboBox GraphtheoryChoose  = new JComboBox(listData);//下拉选择框
        GraphtheoryChoose.setPreferredSize(new Dimension(300,50));
        GraphtheoryChoose.setRenderer(new CustomListCellRenderer()); // 设置自定义渲染器
        GraphtheoryChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    if(AllowedtoAdd==1){
//                        TaskListed.add(GraphtheoryChoose.getSelectedItem().toString());
                        TaskList.addItem(GraphtheoryChoose.getSelectedItem().toString());
                        queue.add(GraphtheoryChoose.getSelectedItem().toString());
                    }
                    migong=0;
                    beibao=0;
                    System.out.println("你选择了："+GraphtheoryChoose.getSelectedItem()+"是第"+ (GraphtheoryChoose.getSelectedIndex()+1)+"个选项");
                    name=GraphtheoryChoose.getSelectedItem().toString();
                    methodd.setText(name);
                    if(GraphtheoryChoose.getSelectedItem()=="  TSP")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    else if(GraphtheoryChoose.getSelectedItem()=="  完全背包"||GraphtheoryChoose.getSelectedItem()=="  0-1背包") {
                        methodd2.setText("需要一组可多维，一组一维变量");
                        methodd2.setText("需要一组可多维，一组一维变量");
                        JFrame jf = new JFrame("设置背包容量");
                        Box bbBox1=Box.createHorizontalBox();
                        Box bbBox2=Box.createHorizontalBox();
                        Box bbBox4=Box.createVerticalBox();
                        Box bbBox3=Box.createVerticalBox();
                        JLabel jbin=new JLabel("输入背包容量:",SwingConstants.CENTER);
                        jbin.setPreferredSize(new Dimension(100,200));
                        jbeibao.setHorizontalAlignment(JTextField.CENTER);
                        JButton jjjb=new JButton("确定");
                        jjjb.setFont(new Font("微软雅黑", Font.BOLD, 13));
                        jjjb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                weight=jbeibao.getText();
                                System.out.println(weight);
                                beibao=1;
                            }
                        });
                        bbBox1.add(jbin);
                        bbBox1.add(jbeibao);
                        bbBox3.add(bbBox1);
                        bbBox3.add(bbBox2);
                        JLabel jllb=new JLabel("请输入正数",SwingConstants.CENTER);
                        jllb.setSize(1000,30);
                        jllb.setFont(new Font("微软雅黑", Font.BOLD, 13));
                        bbBox3.add(jllb);
                        bbBox3.add(jjjb);
                        jf.add(bbBox3);
                        jf.setVisible(true);
                        jf.setResizable(true);
                        jf.setSize(650,400);
                        jf.setLocation(450,200);
                        System.out.println(bb);
                        if(bb.size()>2)
                            bb.set(3,name);

                    }

                    else if(GraphtheoryChoose.getSelectedItem()=="  指派问题")
                        methodd2.setText("需要一组多维变量");
                    else if(GraphtheoryChoose.getSelectedItem()=="  装载问题")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    else if(GraphtheoryChoose.getSelectedItem()=="  约瑟夫问题")
                        methodd2.setText("需要一组一维变量");
                    else if(GraphtheoryChoose.getSelectedItem()=="  迪杰斯特拉算法")
                        methodd2.setText("需要邻接矩阵");
                    else if(GraphtheoryChoose.getSelectedItem()=="  最小生成树算法")
                        methodd2.setText("需要邻接矩阵");
                    else if(GraphtheoryChoose.getSelectedItem()=="  迷宫问题"){//为啥触发两次
                        methodd2.setText("需要导入1为墙0为通路的迷宫矩阵");
                        JFrame jf = new JFrame("迷宫问题的起点与终点");
                        Box bbBox1=Box.createHorizontalBox();
                        Box bbBox2=Box.createHorizontalBox();
                        Box bbBox4=Box.createVerticalBox();
                        Box bbBox3=Box.createVerticalBox();
                        JLabel jbin=new JLabel("输入起点坐标",SwingConstants.CENTER);
                        jbin.setPreferredSize(new Dimension(100,200));
//                        JTextField jjt=new JTextField("0,0");
                        jjt.setHorizontalAlignment(JTextField.CENTER);
                        JLabel jbin2=new JLabel("输入终点坐标",SwingConstants.CENTER);
                        jbin2.setPreferredSize(new Dimension(100,200));
//                        JTextField jjt2=new JTextField("3,3");
                        jjt2.setHorizontalAlignment(JTextField.CENTER);
                        JButton jjjb=new JButton("确定");
                        jjjb.setFont(new Font("微软雅黑", Font.BOLD, 13));
                        jjjb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                positions.add(jjt.getText());
                                positions.add(jjt2.getText());
//                                position[1]=jjt2.getText();
//                                System.out.println(position[0]);
                                migong=1;
                            }
                        });
                        bbBox1.add(jbin);
                        bbBox1.add(jjt);
                        bbBox2.add(jbin2);
                        bbBox2.add(jjt2);
                        bbBox3.add(bbBox1);
                        bbBox3.add(bbBox2);
                        JLabel jllb=new JLabel("坐标示例：a,b",SwingConstants.CENTER);
                        jllb.setSize(1000,30);
                        jllb.setFont(new Font("微软雅黑", Font.BOLD, 13));

                        bbBox3.add(jllb);
                        bbBox3.add(jjjb);


//                        jllb.setPreferredSize(new Dimension(500,70));
//                        bbBox3.add(jllb);
//                        bbBox3.add(jjjb);
//                    jf.add(jllb);
//                    jf.add(bbBox1);
//                    jf.add(bbBox2);
                        jf.add(bbBox3);

                        jf.setVisible(true);
                        jf.setResizable(true);
                        jf.setSize(650,400);
                        jf.setLocation(450,200);
                    }
                    if(bb.size()>2)
                        bb.set(3,name);
                }
                //SELECTED 此状态更改值指示项被选定
                //getStateChange()返回被影响的方式：去选择/选择
//                if (e.SELECTED == e.getStateChange()) {
                //getSelectedItem()返回当前所选项
                //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
//                }
            }
        });
        GraphtheoryChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));

        listData = new String[]{" 统计建模问题","  游程检验","  泊松分布检验","  正态分布检验"};
        JComboBox StatisticalmodelingChoose = new JComboBox(listData);//下拉选择框
        StatisticalmodelingChoose.setPreferredSize(new Dimension(300,50));
        StatisticalmodelingChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
            public void itemStateChanged(ItemEvent e) {
                migong=0;beibao=0;
                //SELECTED 此状态更改值指示项被选定
                //getStateChange()返回被影响的方式：去选择/选择
//                if (e.SELECTED == e.getStateChange()) {
                //getSelectedItem()返回当前所选项
                //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
                System.out.println("你选择了："+StatisticalmodelingChoose.getSelectedItem()+"是第"+ (StatisticalmodelingChoose.getSelectedIndex()+1)+"个选项");
                name=StatisticalmodelingChoose.getSelectedItem().toString();
                methodd.setText(name);
                if(StatisticalmodelingChoose.getSelectedItem()=="  游程检验")
                    methodd2.setText("需要一组可多维，一组一维变量");
                else if(StatisticalmodelingChoose.getSelectedItem()=="  泊松分布检验")
                    methodd2.setText("需要一组可多维，一组一维变量");
                else if(StatisticalmodelingChoose.getSelectedItem()=="  正态分布检验")
                    methodd2.setText("需要一组可多维，一组一维变量");
//                else if(StatisticalmodelingChoose.getSelectedItem()=="  随机森林分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
//                else if(StatisticalmodelingChoose.getSelectedItem()=="  K近邻(KNN)分类")
//                    methodd2.setText("需要一组可多维，一组一维变量");
                if(bb.size()>2)
                    bb.set(3,name);
//                }
            }
        });
        StatisticalmodelingChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));

        listData = new String[]{" 机器学习回归","  决策树回归","  adaboost回归","  随机森林回归","  K近邻(KNN)回归"};
        JComboBox MachineLearningRegressChoose = new JComboBox(listData);//下拉选择框
        MachineLearningRegressChoose.setPreferredSize(new Dimension(300,50));
        MachineLearningRegressChoose.setRenderer(new CustomListCellRenderer()); // 设置自定义渲染器
        MachineLearningRegressChoose.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if(AllowedtoAdd==1){
//                        TaskListed.add(GraphtheoryChoose.getSelectedItem().toString());
                        TaskList.addItem(MachineLearningRegressChoose.getSelectedItem().toString());
                        queue.add(MachineLearningRegressChoose.getSelectedItem().toString());
                    }
                    migong = 0;beibao=0;
                    //SELECTED 此状态更改值指示项被选定
                    //getStateChange()返回被影响的方式：去选择/选择
                    //                if (e.SELECTED == e.getStateChange()) {
                    //getSelectedItem()返回当前所选项
                    //getSelectedIndex()返回列表中与给定项匹配的第一个选项。
                    System.out.println("你选择了：" + MachineLearningRegressChoose.getSelectedItem() + "是第" + (MachineLearningRegressChoose.getSelectedIndex() + 1) + "个选项");
                    name = MachineLearningRegressChoose.getSelectedItem().toString();
                    methodd.setText(name);
                    if (MachineLearningRegressChoose.getSelectedItem() == "  决策树回归")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    else if (MachineLearningRegressChoose.getSelectedItem() == "  逻辑回归")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    else if (MachineLearningRegressChoose.getSelectedItem() == "  adaboost回归")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    else if (MachineLearningRegressChoose.getSelectedItem() == "  随机森林回归")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    else if (MachineLearningRegressChoose.getSelectedItem() == "  K近邻(KNN)回归")
                        methodd2.setText("需要一组可多维，一组一维变量");
                    if (bb.size() > 2)
                        bb.set(3, name);

                    //                }
                }
            }
        });
        MachineLearningRegressChoose.setFont(new Font("微软雅黑", Font.BOLD, 13));

//        bBoxLeft.add(EvaluateChoose);
        bBoxLeft.add(Box.createGlue());
//        bBoxLeft.add(PredictChoose);
//        bBoxLeft.add(ReturnChoose);
//        bBoxLeft.add(TimeSeriesChoose);
//        bBoxLeft.add(MachineLearningChoose);
        bBoxLeft.add(GraphtheoryChoose);
//        bBoxLeft.add(StatisticalmodelingChoose);
        bBoxLeft.add(MachineLearningRegressChoose);
        bBoxLeft.add(DataProcessingChoose);
        bBoxLeft.add(PictureProcessingChoose);
        JLabel jl=new JLabel("算法选择",SwingConstants.CENTER);
        jl.setPreferredSize(new Dimension(440,100));
        jl.setFont(new Font("微软雅黑", Font.BOLD, 15));
        leftPanel.add(jl);
        JCheckBox zt=new JCheckBox("增添任务清单");
//        zt.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (zt.isSelected()) {
//                    System.out.println("选中状态：增添任务清单已选中");
//                    //开始记录点击的事件
//                    TaskList.addItem();
//                } else {
//                    System.out.println("未选中状态：增添任务清单未选中");
//                }
//            }
//        });

//        leftPanel.add(zt);
        leftPanel.add(bBoxLeft);

        JPanel nameee=new JPanel();
        nameee.setPreferredSize(new Dimension(300,30));
        Box namee=Box.createVerticalBox();
        JLabel method=new JLabel(" 您选中的方法为：");
        method.setFont(new Font("宋体", Font.BOLD, 12));
        method.setPreferredSize(new Dimension(300,30));

        methodd=new JLabel(" ",SwingConstants.CENTER);
        methodd.setFont(new Font("微软雅黑", Font.BOLD, 13));
        methodd.setPreferredSize(new Dimension(300,30));

//        namee.add(method);
//        namee.add(methodd);
//        nameee.add(namee);

//        leftPanel.add(method);
//        leftPanel.add(methodd);
        leftPanel.add(method);
        leftPanel.add(methodd);
//        leftPanel.add(namee);

        JLabel method2=new JLabel("算法所需组别与标签数：");
        method2.setFont(new Font("宋体", Font.BOLD, 12));
        method2.setPreferredSize(new Dimension(300,30));
        leftPanel.add(method2);
        JPanel jp2=new JPanel();
        jp2.setPreferredSize(new Dimension(540,40));
        methodd2=new JLabel(" ",SwingConstants.CENTER);
        methodd2.setFont(new Font("微软雅黑", Font.BOLD, 13));
        methodd2.setPreferredSize(new Dimension(300,30));
//                Box boxleft=Box.createHorizontalBox();
//                boxleft.add(method2);
        //        leftPanel.add(boxleft);
        leftPanel.add(methodd2);
//        leftPanel.add(jp2);


        Box boxx=Box.createVerticalBox();
        JButton jb2=new JButton("算法详解 >");
        jb2.addActionListener(new ActionListener() { // 下一步的按钮动作
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jff=new JFrame("算法详解");
                jff.setResizable(false);
                jff.setSize(1000,800);
                jff.setLocation(650, 200);
                jff.setVisible(true);
                JTextArea jta=new JTextArea(20,39);
                jta.setText("");
                jta.setFont(new Font("宋体", Font.BOLD, 16));
                jta.setLineWrap(true);
//                 jta.setPreferredSize(new Dimension(300,800));
                Box inerboox=Box.createHorizontalBox();
                JPanel jpp=new JPanel();
                //        bBoxLeft.add(EvaluateChoose);

                String[] listData2 = new String[]{" 综合评价类","  优劣解距离法","  主成分分析法", "  熵值法","  CRITIC定权"};
                JComboBox EvaluateChoose2 = new JComboBox(listData2);//下拉选择框
                EvaluateChoose2.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
                    public void itemStateChanged(ItemEvent e) {
                        System.out.println("你选择了："+EvaluateChoose2.getSelectedItem()+"是第"+ (EvaluateChoose.getSelectedIndex()+1)+"个选项");
                        if(EvaluateChoose2.getSelectedItem()=="  优劣解距离法"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("TOPSIS 法是一种常用的组内综合评价方法，" +
                                    "能充分利用原始数据的信息，其结果能精确地反映各评价方案之间的差距。" +
                                    "基本过程为基于归一化后的原始数据矩阵，采用余弦法找出有限方案中的最优方案和最劣方案，" +
                                    "然后分别计算各评价对象与最优方案和最劣方案间的距离，获得各评价对象与最优方案的相对接近程度，" +
                                    "以此作为评价优劣的依据。该方法对数据分布及样本含量没有严格限制，数据计算简单易行。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入:至少两项或以上的定量变量。\n" +
                                    "输出:反应考核指标在量化评价中的综合得分。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("进行 TOPSIS 分析时，各个指标有着权重属性（当然通常情况并没有），" +
                                    "那么可对应设置各个指标的权重（输入的权重值可以为相对数字，" +
                                    "程序 默认都会进行归一化处理让权重加和为 1），" +
                                    "在进行 D+和 D-值计算时，程序会对应乘上权重值（如果没有权重则下述公式中权重值为 1），");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("TOPSIS 法的基本思想是: 对原始数据同趋 势后构建归一化矩阵， 计算评价对象与最优向量和最劣向量的 差异， 以此测度评价对象的差异。 假设有 n 个评价对象，m 个 指标， TOPSIS 法的基本步骤为:\n" +
                                    "步骤 1 原始数据同趋势化\n" +
                                    "区分指标体系中的指标类别 (高优或低优） ，并根据不同类型的指标需要按照不同的公式进行正向化处理。\n" +
                                    "构建 n 行 m 列的矩阵 Xij， 矩阵中 X 表示第 i 个对象的第 j 个指标的值。\n" +
                                    "步骤 2 构建标准化矩阵\n"+
                                    "步骤 3 计算各评价指标与最优及最劣向量之间的差距,其中 wj 为第 j 个属性的权重（重要程度）。");
                            jta.append("\n");
                            jta.append("步骤 4 测度 评价对象与最优方案的接近程度");
                            jta.append("\n");
                            jta.append("Ci 值越大， 表明评价对象越优");
                            jta.append("\n");
                        }
                        else if(EvaluateChoose2.getSelectedItem()=="  主成分分析法"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("主成分分析将多个有一定相关性的指标进行线性组合，以最少的维度解释原数据中尽可能多的信息为目标进行降维，降维后的各变量间彼此线性无关，最终确定的新变量是原始变量的线性组合，且越往后主成分在方差中的比重也小，综合原信息的能力越弱，与因子分析不同的是，因子分析是利用少数几个公共因子去解释较多个要观测变量中存在的关系，它不是对原始变量的重新组合。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：2 个或两个以上的定量变量（假设为 N 个变量）\n" +
                                    "输出:最低可降维成 1 维（一个变量，一般用于综合评价），最多可降维成 N 个变量（一般用于数据脱敏），同时可以获取降维后各个变量的组成权重，用于代表原先变量的数据保留情况。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("主成分要求变量之间的共线性或相关关系比较强，否则不能通过 KMO 检验和 Bartlett 球形检验；\n" +
                                    "主成分分析倾向于降维，从而达到简化系统结构，抓住问题实质的目的。（可侧重于输出结果 2、输出结果 3、输出结果 8）；\n" +
                                    "主成分分析时通常需要综合自己的专业知识，以及软件结果进行综合判断，即使是特征根值小于 1，也一样可以提取主成分；\n" +
                                    "KMO 值为 null 不存在可能导致的原因为：\n" +
                                    "（1）样本量过少容易导致相关系数过高，一般希望分析样本量大于 5 倍分析项个数；\n" +
                                    "（2）各个分析项之间的相关关系过高或过低。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("主成分分析法是运用“降维”思想，把多个指标 变换成少数综合指标的多元统计方法，这里的综合 指标就是主成分。每个主成分都是原始变量的线性组合，彼此相互独立，并保留了原始变量绝大部分信息。其本质是通过原始变量的相关性，寻求相关变 量的综合替代对象，并且保证了转化过程中的信息损失最小 。\n" +
                                    "根据标准化后的数据集计算协方差矩阵Ｒ:\n" +"计算矩阵 Ｒ 的特征值 λ １ ≥λ ２ ≥…≥λ ｎ ≥ ０及 对应的特征向量 ｕ１ ,ｕ２ ,…,ｕｎ ,其中 ｕｊ＝ (ｕ１ j,ｕ２ j, …,ｕ nj) ,ｕ nj 表示第 j 个特征向量的第 n 个分量; 由特征向量组成 n 个新的指标变量:\n"+"式中,ｙ 1 是第 1 主成分,ｙ 2 是第 2 主成分,…,ｙ n 是第 n 主成分。 计算各主成分ｙ j 贡献率 ｂ j(j=1,2,...,n) 及 ｙ 1,ｙ 2 ,…,ｙ n (ｐ ≤ ｎ)的累计贡献率 αｐ 。");
                            jta.append("\n");
                        }
                        else if(EvaluateChoose2.getSelectedItem()=="  熵值法"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("熵值法根据信息熵的定义，对于某项指标，可以用熵值来判断某个指标的离散程度，其信息熵值越小，指标的离散程度越大， 该指标对综合评价的影响（即权重）就越大，如果某项指标的值全部相等，则该指标在综合评价中不起作用。因此，可利用信息熵这个工具，计算出各个指标的权重，为多指标综合评价提供依据。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：至少两项或以上的定量变量（可以做正、负向处理，但是不要做标准化）。\n" +
                                    "输出：输入定量变量对应的权重值");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("程序导入表格需要进一行标准化；\n" +
                                    "熵值法的计算公式上会有取对数，因此如果小于等于 0 的数字取对数，则会出现 null 值，所以需要对于数据采用非负平移进行处理，即如果某列（某指标）数据出现小于等于 0，则让该列数据同时加上一个‘平移值’【该值为某列数据最小值的绝对值+0.01】，以便让数据全部都大于 0，因而满足算法要求。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("熵是信息论中的概念，是对不确定性的一种度量。信息量越大，不确定性越小，熵就越小；信息量越小，不确定性越大，熵也越大。根据信息熵的定义，对于某项指标可用熵值来判断某个指标的离散 程度，其熵值越小，指标的离散程度越大，该指标对综合评价的影响(即权重)也越大。");
                            jta.append("\n");
                        }
                        else if(EvaluateChoose2.getSelectedItem()=="  CRITIC定权"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("CRITIC 权重法是一种客观赋权法。其思想在于用两项指标，分别是对比强度和冲突性指标。对比强度使用标准差进行表示，如果数据标准差越大说明波动越大，权重会越高；冲突性使用相关系数进行表示，如果指标之间的相关系数值越大，说明冲突性越小，那么其权重也就越低。对于多指标多对象的综合评价问题，CRITIC 法去消除一些相关性较强的指标的影响，减少指标之间信息上的重叠，更有利于得到可信的评价结果。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：至少两项或以上的定量变量（可以做正、负向处理，但是不要做标准化）。\n" +
                                    "输出：输入定量变量对应的权重值");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("在进行 CRITIC 权重法前，需要对数据进行归一化，达到去量纲的目的。\n" +
                                    "CRITIC 权重法得到权重值后，此时归一化后数据与对应的权重相乘，并且进行累加，得到综合得分（需自行计算）。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("CRITIC 法是一种比熵权法和标准离差法更好的客观赋权法。\n" +
                                    "它是基于评价指标的对比强度和指标之间的冲突性来综合衡量指标的客观权重。考虑指标变异性大小的同时兼顾指标之间的相关性，并非数字越大就说明越重要，完全利用数据自身的客观属性进行科学评价。对比强度是指同一个指标各个评价方案之间取值差距的大小，以标准差的形式来表现。标准差越大，说明波动越大，即各方案之间的取值差距越大，权重会越高；指标之间的冲突性，用相关系数进行表示，若两个指标之间具有较强的正相关，说明其冲突性越小，权重会越低。\n" +
                                    "对于 CRITIC 法而言，在标准差一定时，指标间冲突性越小，权重也越小；冲突性越大，权重也越大；另外，当两个指标间的正相关程度越大时，（相关系数越接近 1），冲突性越小，这表明这两个指标在评价方案的优劣上反映的信息有较大的相似性。");
                            jta.append("\n");
                        }

//                }
                    }
                });
                EvaluateChoose2.setFont(new Font("微软雅黑", Font.BOLD, 13));
                EvaluateChoose2.setPreferredSize(new Dimension(300,40));

                listData2 = new String[]{" 图论与组合优化问题","  TSP","  完全背包","  0-1背包","  指派问题","  装载问题"};
                JComboBox GraphtheoryChoose2  = new JComboBox(listData2);//下拉选择框
                GraphtheoryChoose2.setPreferredSize(new Dimension(300,40));
                GraphtheoryChoose2.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
                    public void itemStateChanged(ItemEvent e) {
                        System.out.println("你选择了："+GraphtheoryChoose2.getSelectedItem()+"是第"+ (GraphtheoryChoose2.getSelectedIndex()+1)+"个选项");
                        if(GraphtheoryChoose2.getSelectedItem()=="  TSP"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("旅行商问题（Traveling Salesman Problem）是计算机科学中的一个经典问题，它的目标是找到一条路径，使得经过所有给定的城市，且回到起点的总路程最短。\n" +
                                    "\n" +
                                    "旅行商问题的作用非常广泛。它是一个NP难问题，也是优化问题中的经典问题之一，因此在算法设计、运筹学、网络优化等领域都有着广泛的应用");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：至少两项或以上的定量变量（可以做正、负向处理，但是不要做标准化）。\n" +
                                    "输出：输出旅行商问题所得最优路径");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("将旅行商问题导入表格处理前，需要先将数据按照一定的格式进行整理。一般情况下，需要将各个城市之间的距离或者花费等数据整理成矩阵或者列表的形式，并确保数据的准确性和完整性。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("TSP可以用图论的方式进行建模，将城市看做图中的节点，路径长度看做边的权重。这样，旅行商问题就可以表示为在给定的带权完全图中找到一个哈密顿回路，使得回路上各条边的权重之和最小。\n" +
                                    "假设有n个城市，城市之间的距离用d(i,j)表示，i和j分别表示城市的编号（i,j∈{1,2,…,n}）。令x(i,j)表示城市i和城市j之间的路径是否被包含在旅行商的路径中，0表示不包含，1表示包含。则TSP问题可以表示为以下的数学模型：\n" +
                                    "minimize:\n" +
                                    "sum_{i=1}^n sum_{j=1}^n d(i,j) * x(i,j)\n" +
                                    "subject to:\n" +
                                    "sum_{i=1}^n x(i,j) = 1, for j=1,2,…,n\n" +
                                    "sum_{j=1}^n x(i,j) = 1, for i=1,2,…,n\n" +
                                    "sum_{i=1}^n sum_{j=1}^n x(i,j) = n\n" +
                                    "x(i,j) ∈ {0,1}, for i,j=1,2,…,n\n" +
                                    "x(i,j) = x(j,i), for i,j=1,2,…,n\n" +
                                    "其中，目标函数表示旅行商走过所有城市所需要走的总距离，约束条件1和2保证每个城市只能被经过一次，约束条件3保证旅行商的路径经过所有城市，约束条件4和5分别表示x(i,j)只能取0或1，且x(i,j)等于x(j,i)。");
                            jta.append("\n");
                        }
                        else if(GraphtheoryChoose2.getSelectedItem()=="  完全背包"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("完全背包问题是经典的背包问题之一，其作用非常广泛，常用于各种资源分配问题的求解，例如：\n" +
                                    "产品设计：在产品设计中，需要将各种不同的元素组合起来以达到特定的目标。完全背包问题可以帮助设计师确定如何选择不同的元素以满足预期的设计目标。\n" +
                                    "资源分配：在资源分配问题中，需要决定如何分配不同的资源以达到最大的收益或效益。例如，在项目管理中，需要合理地分配人力、物力、财力等资源，以保证项目的成功实施。完全背包问题可以帮助管理者决策如何分配资源。\n" +
                                    "生产计划：在生产计划中，需要决定哪些产品应该生产以最大化产量和利润。完全背包问题可以帮助生产计划员确定哪些产品应该生产以达到最大利润。\n" +
                                    "金融投资：在金融投资中，需要决定如何分配不同的投资产品以获得最大的回报。完全背包问题可以帮助投资者决策如何选择不同的投资产品以达到最大的回报。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：\n" +
                                    "一个背包容量的上限W；\n" +
                                    "n个物品，每个物品有一个重量w[i]和一个价值v[i]。\n" +
                                    "输出：\n" +
                                    "将这些物品放入容量为W的背包中，使得背包中的物品总价值最大。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("背包容量：背包容量应该是一个正整数，表示背包能够容纳的最大重量。\n" +
                                    "物品重量和价值：对于每一个物品，应该提供它的重量和价值。重量应该是一个正整数，表示物品的重量；价值也应该是一个正整数，表示物品的价值。\n" +
                                    "物品数量：完全背包问题中的物品可以无限制地放入背包中，因此不需要提供每种物品的数量。\n" +
                                    "输入数据格式：通常情况下，输入数据表格其中每一行表示一个物品，包括它的重量和价值。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("熵是信息论中的概念，是对不确定性的一种度量。信息量越大，不确定性越小，熵就越小；信息量越小，不确定性越大，熵也越大。根据信息熵的定义，对于某项指标可用熵值来判断某个指标的离散 程度，其熵值越小，指标的离散程度越大，该指标对综合评价的影响(即权重)也越大。");
                            jta.append("\n");
                        }
                        else if(GraphtheoryChoose2.getSelectedItem()=="  0-1背包"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("背景是：有一个容量为C的背包和n个物品，每个物品的重量为w[i]，价值为v[i]。每个物品最多只能选择一次放入背包中，问在背包容量有限的情况下，能够装入背包的最大价值是多少？\n" +
                                    "0-1背包问题是一个重要的优化问题，它在实际应用中有着广泛的应用。以下是一些典型的应用场景：\n" +
                                    "生产计划：在制造企业中，0-1背包问题可以用来计算最优的生产计划，以最大化产出并避免浪费。\n" +
                                    "物流配送：在物流配送领域，0-1背包问题可以用来计算最优的货物装载方案，以最大化运输效率并降低成本。\n" +
                                    "股票投资：在股票投资领域，0-1背包问题可以用来计算最优的投资组合，以最大化收益并降低风险。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：\n" +
                                    "一个背包容量的上限W；\n" +
                                    "n个物品，每个物品有一个重量w[i]和一个价值v[i]。\n" +
                                    "输出：\n" +
                                    "将这些物品放入容量为W的背包中，使得背包中的物品总价值最大。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("物品的数量和背包的容量都应该是正整数，如果输入的数据不符合要求，程序可能会出现异常。\n" +
                                    "物品的重量和价值都应该是非负整数，如果输入的数据不符合要求，程序可能会出现异常。\n" +
                                    "物品的重量和价值都应该是已知的，如果数据不完整或者存在错误，可能会导致程序计算出错。\n" +
                                    "物品的顺序并不影响计算结果，因此可以按照任意顺序输入物品，不会影响计算结果。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("定义一个二维数组dp[i][j]表示将前i个物品装入容量为j的背包中能获得的最大价值，dp[i][j]的计算需要考虑两种情况：\n" +
                                    "第i个物品不装入背包，此时dp[i][j]等于dp[i-1][j]。\n" +
                                    "第i个物品装入背包，此时dp[i][j]等于dp[i-1][j-w[i]]+v[i]。\n" +
                                    "综合以上两种情况，可以得到状态转移方程：\n" +
                                    "dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i]]+v[i])\n" +
                                    "边界条件是：" +
                                    "dp[0][j] = 0, dp[i][0] = 0\n" +
                                    "最终的答案是：" +
                                    "dp[n][C]\n" +
                                    "其中，n表示物品的数量，C表示背包的容量。");
                            jta.append("\n");
                        }
                        else if(GraphtheoryChoose2.getSelectedItem()=="  指派问题"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("指派问题是一个经典的优化问题，它的背景是：有n个人和n个任务，每个人可以完成任意一个任务，但每个任务只能由一个人完成。每个人完成不同任务所需的时间和成本可能不同，问如何分配任务可以使得总时间或总成本最小。\n" +
                                    "指派问题在实际应用中具有广泛的作用，");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("指派问题的数据输入通常是一个n x n的矩阵，其中第i行第j列的数表示第i个人完成第j个任务所需的时间或成本。通常情况下，时间和成本是可以互相转换的，因此可以根据具体的问题来决定选用哪一种量度。\n" +
                                    "\n" +
                                    "指派问题的数据输出通常是一个长度为n的数组，数组中第i个元素表示第i个人被分配到的任务编号。此外，根据具体的问题，也可以输出完成任务所需的时间或成本，以及任务分配的最小时间或成本。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("数据格式：指派问题通常是由一个n x n的矩阵表示，其中每个元素表示第i个人完成第j个任务所需的时间或成本。因此，在输入数据时，需要按照矩阵的格式进行输入，并且每行或每列之间需要用空格或其他分隔符进行分隔。\n" +
                                    "数据精度：在实际应用中，指派问题的数据通常是实数或整数，需要根据具体问题进行选择。在输入数据时，需要注意数据的精度和范围，避免出现数值溢出或精度误差等问题。\n" +
                                    "数据大小：指派问题的数据规模通常较大，需要根据具体问题进行选择。在输入数据时，需要确保计算机的硬件和软件环境能够支持处理该数据规模的问题。\n" +
                                    "数据有效性：在输入数据时，需要确保数据的有效性和正确性，避免出现数据错误或数据缺失等问题。同时，需要注意数据的一致性和完整性，确保数据的正确性和可靠性。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("对于指派问题可以通过以下步骤解决：\n"+
                                    "初始化：对于每个任务和执行者，设置初始的匹配为无匹配状态，并初始化标记数组为0。\n" +
                                    "寻找增广路径：对于每个未匹配的任务，从该任务开始，通过交替路径的方式寻找增广路径。具体来说，如果当前任务未匹配，则将其作为交替路径的起点；否则，将与该任务匹配的执行者作为交替路径的起点。从起点开始，依次访问与之匹配的执行者、与之匹配的任务、与之匹配的执行者，以此类推，直到找到一个未匹配的任务为止。\n" +
                                    "改变匹配：如果找到了增广路径，则可以将该路径上的任务和执行者互相匹配。如果路径上的任务原本已经与其他执行者匹配，则需要将该任务与原来的执行者解除匹配。在改变匹配后，需要更新标记数组的值。\n" +
                                    "终止条件：如果不存在增广路径，则当前的匹配即为最终的匹配。如果存在增广路径，则需要重复步骤2和步骤3，直到不存在增广路径为止。");
                            jta.append("\n");
                        }
//                         else if(GraphtheoryChoose2.getSelectedItem()=="  装载问题")
//                }
                    }
                });
                GraphtheoryChoose2.setFont(new Font("微软雅黑", Font.BOLD, 13));
                GraphtheoryChoose2.setPreferredSize(new Dimension(300,40));

                listData2 = new String[]{" 统计建模问题","  游程检验","  泊松分布检验"};
                JComboBox StatisticalmodelingChoose2 = new JComboBox(listData2);//下拉选择框
                StatisticalmodelingChoose2.setPreferredSize(new Dimension(300,40));
                StatisticalmodelingChoose2.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
                    public void itemStateChanged(ItemEvent e) {
                        System.out.println("你选择了："+StatisticalmodelingChoose2.getSelectedItem()+"是第"+ (StatisticalmodelingChoose2.getSelectedIndex()+1)+"个选项");
                        if(StatisticalmodelingChoose2.getSelectedItem()=="  游程检验"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("游程检验是根据样本标志表现排列所形成的游程的多少进行判断的检验方法，简单地说其主要检验一件事情发生的概率是否为随机的，游程检验在检验样本的随机性及判断数据的规律性等方面有着重要的作用。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：单列或多列定量数据，如 30 只灯泡的寿命、生产流程中产生的次品次数。\n" +
                                    "输出：模型检验结果，如灯泡的寿命长短是（不是）随机的、产生的次品次数是/不是随机的。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("游程检验是一种非参数性统计假设的检验方法，可用于确定数据集是否呈现随机性的方法，本质是独立性检验。\n" +
                                    "其要求数据为二分类数据（数据为 0 或 1），当用户导入的数据是连续变量时，SPSSPRO 会默认以中位数作为切割点，对原始数据进行处理。其检验原理是将数据分为两类，看前一个个案是否会影响后一个个案，进而得出数据是否随机。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("记 r 为游程总数,n1、n2 分别代表价格上升、价格下降的个数。n 为所取的样本数,即 n1+n2=n。这样,在价格变化呈现随机波动的价格下, 当 n 很大时,r 近似地服从正态分布。设 ur 为正态分布条件下随机序列游程数的期望值, σr 为方差。那么我们就可以得到统计量:\n"+
                                    "在给定显著性水平 α, 已知样本为 n 的情况下,\n" +
                                    "可以得出统计量 Z 的临界值 Zα/2, 若从样本中得到的z >Zα/2, 就可以拒绝原假设 , 即序列不是随机的。\n" +
                                    "否则 ,接受原假设, 即序列是随机的。0");
                            jta.append("\n");
                        }
                        else if(StatisticalmodelingChoose2.getSelectedItem()=="  泊松分布检验"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("泊松分布描述的是一个小概率事件在单位时间内发生的次数，如每个小时进入银行办理业务的人数、报纸上每一页的错别字数量、某个网页的点击量等，简单地说，就是泊松检验的是某种事件是否发生概率很低，且很稳定，同时发生频数的大小之间没有影响关系，例如在一定时间内产品产生的用户需求数，上周发生的用户提的需求数跟这周的没关系。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：泊松分布检验有两种输入方式，由于泊松分布检验是描述的是一个小概率事件在单位时间内发生的次数，则次数是正整数，是分类离散变量，但是其表现形式可能是数值型（次数)，所以对于“单位时间内发生次数”格式，定量或定类的都可以。\n" +
                                    "\n" +
                                    "若是直接输入一连串单位时间内发生次数的序列，要求变量格式为定量或者定类，spsspro 会对单位时间内发生次数进行频数分析后，再进行泊松分布检验。\n" +
                                    "若是已对单位时间内发生次数进行频数分析后，即要输入“单位时间内发生次数”和其对应”频数“，把“频数”放入到加权项中，其中加权项格式为定量。\n" +
                                    "输出：是否呈现泊松分布。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("由于泊松分布的取值为 0 和大于 0 的正整数，故输入数据有两种形式：\n" +
                                    "1)若不输入权数，则数据必须为 0 和大于 0 的正整数，此时的数据为定量。\n" +
                                    "2)若输入权数，则数据为定类数据，而权数代表发生的频次。\n" +
                                    "在 poisson 检验表中:\n" +
                                    "1)若不输入权数：\n" +
                                    "若最大值减去最小值+1 的值小于 200，则中间的空值会自动补全，然后取去重次数。\n" +
                                    "若大于 200，则直接按期望值计算。\n" +
                                    "2)若输入权数，则直接按期望值计算。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("泊松分布的拟合检验：在长为 t 的时间间隔内观测事件 A 发生的次数 X(t),将这样的观测重复进行 m 次,\n" +
                                    "记 Ai={X(t)=i}(i = 0,1,2,…,n)为一次观测中事件 A 发生 i 次这个事件。A0,A1,…An 在 m 次观测中出现的频数分别为 m0,m1,…,mn,且。\n" +
                                    "上述假定用到以下事实:即使是泊松分布, 重复观测 m 次时,也只能观测到有限个不同的值,我们需要检验的假设为事件流 X(t)是否服从泊松分布 P(λ),其中 P 为未知参数。将检验的假设 X(t) ～ p(λ)转化为检验以下假设:\n" +
                                    "这里有一个未知参数 λ,采用极大似然估计:\n" +
                                    "将λ代入第二个公式可以估计出pi。可用X2检验H0检验统计量:\n" +
                                    "在H0成立时近似服从自由度为n+1-1-1 = n-1的X2分布。给定显著性水平α,可得H0的拒绝域\n");
                            jta.append("\n");
                        }
                        else if(StatisticalmodelingChoose2.getSelectedItem()=="  正态分布检验"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("泊松分布描述的是一个小概率事件在单位时间内发生的次数，如每个小时进入银行办理业务的人数、报纸上每一页的错别字数量、某个网页的点击量等，简单地说，就是泊松检验的是某种事件是否发生概率很低，且很稳定，同时发生频数的大小之间没有影响关系，例如在一定时间内产品产生的用户需求数，上周发生的用户提的需求数跟这周的没关系。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：泊松分布检验有两种输入方式，由于泊松分布检验是描述的是一个小概率事件在单位时间内发生的次数，则次数是正整数，是分类离散变量，但是其表现形式可能是数值型（次数)，所以对于“单位时间内发生次数”格式，定量或定类的都可以。\n" +
                                    "\n" +
                                    "若是直接输入一连串单位时间内发生次数的序列，要求变量格式为定量或者定类，spsspro 会对单位时间内发生次数进行频数分析后，再进行泊松分布检验。\n" +
                                    "若是已对单位时间内发生次数进行频数分析后，即要输入“单位时间内发生次数”和其对应”频数“，把“频数”放入到加权项中，其中加权项格式为定量。\n" +
                                    "输出：是否呈现泊松分布。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("由于泊松分布的取值为 0 和大于 0 的正整数，故输入数据有两种形式：\n" +
                                    "1)若不输入权数，则数据必须为 0 和大于 0 的正整数，此时的数据为定量。\n" +
                                    "2)若输入权数，则数据为定类数据，而权数代表发生的频次。\n" +
                                    "在 poisson 检验表中:\n" +
                                    "1)若不输入权数：\n" +
                                    "若最大值减去最小值+1 的值小于 200，则中间的空值会自动补全，然后取去重次数。\n" +
                                    "若大于 200，则直接按期望值计算。\n" +
                                    "2)若输入权数，则直接按期望值计算。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("泊松分布的拟合检验：在长为 t 的时间间隔内观测事件 A 发生的次数 X(t),将这样的观测重复进行 m 次,\n" +
                                    "记 Ai={X(t)=i}(i = 0,1,2,…,n)为一次观测中事件 A 发生 i 次这个事件。A0,A1,…An 在 m 次观测中出现的频数分别为 m0,m1,…,mn,且。\n" +
                                    "上述假定用到以下事实:即使是泊松分布, 重复观测 m 次时,也只能观测到有限个不同的值,我们需要检验的假设为事件流 X(t)是否服从泊松分布 P(λ),其中 P 为未知参数。将检验的假设 X(t) ～ p(λ)转化为检验以下假设:\n" +
                                    "这里有一个未知参数 λ,采用极大似然估计:\n" +
                                    "将λ代入第二个公式可以估计出pi。可用X2检验H0检验统计量:\n" +
                                    "在H0成立时近似服从自由度为n+1-1-1 = n-1的X2分布。给定显著性水平α,可得H0的拒绝域\n");
                            jta.append("\n");
                        }


//                }
                    }
                });
                StatisticalmodelingChoose2.setFont(new Font("微软雅黑", Font.BOLD, 13));
                StatisticalmodelingChoose2.setPreferredSize(new Dimension(300,40));

                listData2 = new String[]{" 机器学习回归","  决策树回归","  逻辑回归","  adaboost回归","  随机森林回归","  K近邻(KNN)回归"};
                JComboBox MachineLearningRegressChoose2 = new JComboBox(listData2);//下拉选择框
                MachineLearningRegressChoose2.setPreferredSize(new Dimension(300,40));
                MachineLearningRegressChoose2.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
                    public void itemStateChanged(ItemEvent e) {
                        System.out.println("你选择了："+MachineLearningRegressChoose2.getSelectedItem()+"是第"+ (MachineLearningRegressChoose2.getSelectedIndex()+1)+"个选项");
                        if(MachineLearningRegressChoose2.getSelectedItem()=="  决策树回归"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("决策树中每个内部节点都是一个分裂问题：指定了对实例的某个属性的测试，它将到达该节点的样本按照某个特定的属性进行分割，并且该节点的每一个后继分支对应于该属性的一个可能值。回归树的叶节点所含样本中，其输出变量的平均值就是预测结果。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：自变量 X 为 1 个或 1 个以上的定类或定量变量，因变量 Y 为一个定量变量。\n" +
                                    "输出：模型输出的决策树结构图及模型的预测效果。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("由于决策树具有随机性，每次运算的结果不一样。若需要保存本次训练模型，需要使用 SPSSPRO 客户端进行。\n" +
                                    "决策树无法像传统模型一样得到确定的方程，在每个决策节点上，所选择的分割特征决定了最终的分类结果，通常通过测试数据分类效果来对模型进行评价。\n" +
                                    "决策树的参数修改需要使用 SPSSPRO 客户端进行。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("决策树是一树状结构,它从根节点开始,对数据样本进行测试,根据不同的结果将数据样本划分成不同的数据样本子集,每个数据样本子集构成——子节点 。它是通过一系列规则对数据进行分类的过程。它提供一种在什么条件下会得到什么值的类似规则的方法。\n" +
                                    "决策树分为分类树和回归树两种,分类树对离散变量做决策树 ,回归树对连续变量做决策树。\n" +
                                    "决策树作为一棵树,树的根节点是整个数据集合空间,每个分节点是对一个单一变量的测试,该测试将数据集合空间分割成两个或更多块。每个叶节点是属于单一类别的记录。构造决策树的过程为:首先寻找初始分裂。整个训练集作为产生决策树的集合,训练集每个记录必须是已经分好类的。决定哪个属性域(Field)作为目前最好的分类指标。 一般的做法是穷尽所有的属性域,对每个属性域分裂的好坏做出量化,计算出最好的一个分裂 。\n" +
                                    "不同的算法的计算属性域分裂的标准也不太相同 。其次, 重复第一步, 直至每个叶节点内的记录都属于同一类, 增长到一棵完整的树。构造决策树的目的是找出属性和类别间的关系 , 用它来预测将来未知类别的记录的类别。");
                            jta.append("\n");
                        }
                        else if(MachineLearningRegressChoose2.getSelectedItem()=="  逻辑回归"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("逻辑回归是研究二分类因变量观与一些影响因素之间关系的一种多变量分析方法。但如果因变量是多个类别的，则要用到多分类逻辑回归去研究因变量与一些影响因素之间的关系。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：因变量 Y 为分类变量，自变量 X 为至少一项定量变量或定类变量。\n" +
                                    "输出：逻辑回归系数估计以及分类预测的效果评价。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("对于多分类逻辑回归，默认用了将某一类和剩余的类比较作为二分类问题，N 个类别进行 N-1 次分类，得到 N-1 个二分类模型，求出每种二分类对应的概率，概率最高的一类作为新样本的预测结果。\n" +
                                    "逻辑回归如果有输入定类数据，那么要求该定类数据必须为二分类定类数据（哑变量化），因此的输入变量 X2 中要求数据为定类数据，若数据不为二分类定类数据，会自动将其哑变量化");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("对于二分类问题，\n" +
                                    "考虑到  取值是连续的，因此它不能拟合离散变量。可以考虑用它来拟合条件概率  ，因为概率的取值也是连续的。\n" +
                                    "最理想的是单位阶跃函数：\n" +
                                    "但是这个阶跃函数不可微，对数几率函数是一个常用的替代函数：\n" +
                                    "上式可以化成\n" +
                                    "其中， y 视为 x 为正例的概率， 1-y 为 x 为其反例的概率。两者的比值称为几率（odds）。所以，逻辑回归中事实上因变量值应是 odds。\n" +
                                    "将 y 视为类后验概率估计，重写公式有：\n" +
                                    "针对于多分类逻辑回归，默认用了将某一类和剩余的类比较作为二分类问题，N 个类别进行 N-1 次分类，得到 N-1 个二分类模型，求出每种二分类对应的概率，概率最高的一类作为新样本的预测结果。");
                            jta.append("\n");
                        }
                        else if(MachineLearningRegressChoose2.getSelectedItem()=="  adaboost回归"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("adaboost给予误差率低的学习器一个高的权重，给予误差率高的学习器一个低的权重，结合弱学习器和对应的权重，生成强学习器。回归问题与分类问题算法的不同点在于误差率计算的方式不同，分类问题一般都采用0/1损失函数，而回归问题一般都是平方损失函数或者是线性损失函数");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：自变量X为1个或1个以上的定类或定量变量，因变量Y为一个定量变量。\n" +
                                    "输出： 模型输出的预测结果及模型的分类效果。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("由于adaboost具有随机性，每次运算的结果不一样。若需要保存本次训练模型，需要使用客户端进行。\n" +
                                    "adaboost的参数修改需要使用客户端进行。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("AdaBoost，是英文\"Adaptive Boosting\"（自适应增强）的缩写，是一种机器学习方法，由Yoav Freund和Robert Schapire提出。AdaBoost方法的自适应在于：前一个分类器分错的样本会被用来训练下一个分类器。AdaBoost方法对于噪声数据和异常数据很敏感。但在一些问题中，AdaBoost方法相对于大多数其它学习算法而言，不会很容易出现过拟合现象。AdaBoost方法中使用的分类器可能很弱（比如出现很大错误率），但只要它的分类效果比随机好一点（比如两类问题分类错误率略小于0.5），就能够改善最终得到的模型。而错误率高于随机分类器的弱分类器也是有用的，因为在最终得到的多个分类器的线性组合中，可以给它们赋予负系数，同样也能提升分类效果。\n" +
                                    "AdaBoost方法是一种迭代算法，在每一轮中加入一个新的弱分类器，直到达到某个预定的足够小的错误率。每一个训练样本都被赋予一个权重，表明它被某个分类器选入训练集的概率。如果某个样本点已经被准确地分类，那么在构造下一个训练集中，它被选中的概率就被降低；相反，如果某个样本点没有被准确地分类，那么它的权重就得到提高。通过这样的方式，AdaBoost方法能“聚焦于”那些较难分（更富信息）的样本上。\n" +
                                    "在具体实现上，最初令每个样本的权重都相等，对于第k次迭代操作，我们就根据这些权重来选取样本点，进而训练分类器Ck。然后就根据这个分类器，来提高被它分错的的样本的权重，并降低被正确分类的样本权重。然后，权重更新过的样本集被用于训练下一个分类器Ck。整个训练过程如此迭代地进行下去。");
                            jta.append("\n");
                        }
                        else if(MachineLearningRegressChoose2.getSelectedItem()=="  随机森林回归"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("随机森林回归是在生成众多决策树的过程中，是通过对建模数据集的样本观测和特征变量分别进行随机抽样，每次抽样结果均为一棵树，且每棵树都会生成符合自身属性的规则和判断值，而森林最终集成所有决策树的规则和判断值，实现随机森林算法的回归。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：自变量 X 为 1 个或 1 个以上的定类或定量变量，因变量 Y 为一个定量变量。\n" +
                                    "输出： 模型输出的结果值及模型预测效果。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("由于随机森林具有随机性，每次运算的结果不一样。若需要保存本次训练模型。\n" +
                                    "随机森林的参数修改需要使用。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("随机森林是以决策树为基学习器通过集成方式构建 而成的有监督机器学习方法 ,进一步在决策树的训练过程引入了随机性,使其具备优良的抗过拟合 以及抗噪能力. RF 分别从样本选取和特征选择 2 个角度体现其随机性。\n" +
                                    "1) 随机选取样本:RF 中每一棵决策树的样本 集均是从原始数据集中采用 Bootstrap 策略有放回 地抽取、重组形成与原始数据集等大的子集合. 这就意味着同一个子集里面的样本可以是重复出现 的,不同子集中的样本也可以是重复出现的.\n" +
                                    "2) 随机选取特征:不同于单个决策树在分割过 程中考虑所有特征后,选择一个最优特征来分割节 点. RF 通过在基学习器中随机考察一定的特征变 量,之后在这些特征中选择最优特征[16] . 特征变量 考察方式的随机性使得 RF 模型的泛化能力和学习 能力优于个体学习器 。\n" +
                                    "随机森林的算法步骤如下：\n" +
                                    "A）从原始样本集中抽取训练集。每轮从原始样本集中使用 Bootstraping 的方法抽取 n 个训练样本（有放回的抽样）。共进行 k 轮抽取，得到 k 个训练集。（k 个训练集之间是相互独立的）\n" +
                                    "B）每次使用一个训练集得到一个模型，k 个训练集共得到 k 个模型。\n" +
                                    "C）对分类问题：将上步得到的 k 个模型采用投票的方式得到分类结果；对回归问题，计算上述模型的均值作为最后的结果。");
                            jta.append("\n");
                        }
                        else if(MachineLearningRegressChoose2.getSelectedItem()=="  K近邻(KNN)回归"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("k 近邻算法，是将 K 个最近邻实例进行平均处理预测的一种有监督算法。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：自变量 X 为 1 个或 1 个以上的定类或定量变量，因变量 Y 为一个定量变量。\n" +
                                    "输出：模型输出的结果值及模型预测效果。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("若在训练划分时对数据进行洗牌打乱数据顺序，会导致 K 近邻具有随机性，每次运算的结果不一样。若需要保存本次训练模型，需要使用。\n" +
                                    "K 近邻的参数修改需要使用。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("KNN做回归和分类的主要区别在于最后做预测时候的决策方式不同。KNN做分类预测时，一般是选择多数表决法，即训练集里和预测的样本特征最近的K个样本，预测为里面有最多类别数的类别。KNN做回归时，一般是选择平均法，即最近的K个样本的样本输出的平均值作为回归预测值。但它们的理论是一样的。\n" +
                                    "模型介绍：\n" +
                                    "K近邻算法，即是给定一个训练数据集，对新的输入实例，在训练数据集中找到与该实例最邻近的K个实例，这K个实例的平均值作为预测值。\n" +
                                    "看一个最简单的例子，当k=1时，即新实例的类别由里它最近的训练实例的值决定。当k=3时，预测值为最近三个训练样本的值求平均；当k=5时，预测值为最近三个训练样本的值求平均。这里面“最近距离”的定义，是由距离公式求出来的值。\n" +
                                    "K 值的选取：\n" +
                                    "如何选择一个最佳的 K 值取决于数据。一般情况下，在分类时较大的 K 值能够减小噪声的影响，但会使类别之间的界限变得模糊。一个较好的 K 值能通过各种启发式技术来获取。\n" +
                                    "在二元（两类）分类问题中，选取 k 为奇数有助于避免两个分类平票的情形。在此问题下，选取最佳经验 k 值的方法是自助法(Bootstrap)。\n" +
                                    "距离公式：\n" +
                                    "这里面“最近距离”来的定义，是由距离公式求出来的值。距离度量除了常用的欧式距离，还可以使用曼哈顿距离和切比雪夫距离。\n" +
                                    "求解算法：\n" +
                                    "既然我们要找到 k 个最近的邻居来做预测，那么我们只需要计算预测样本和所有训练集中的样本的距离，然后计算出最小的 k 个距离即可，接着多数表决，很容易做出预测。这个方法的确简单直接，在样本量少，样本特征少的时候有效。但是在实际运用中很多时候用不上，为什么呢？因为我们经常碰到样本的特征数有上千以上，样本量有几十万以上，如果我们这要去预测少量的测试集样本，算法的时间效率很成问题。因此，这个方法我们一般称之为蛮力实现。比较适合于少量样本的简单模型的时候用。\n" +
                                    "蛮力实现在特征多，样本多的时候很有局限性，我们可以选择 KD 树或者球树来实现。\n" +
                                    "\n" +
                                    "#");
                            jta.append("\n");
                        }
//                }
                    }
                });
                MachineLearningRegressChoose2.setFont(new Font("微软雅黑", Font.BOLD, 13));
                MachineLearningRegressChoose2.setPreferredSize(new Dimension(300,40));

                listData2 = new String[]{" 数据处理","  样本均衡","  数据标准化"};
                JComboBox DataProcessingChoose2 = new JComboBox(listData2);//下拉选择框
                DataProcessingChoose2.setPreferredSize(new Dimension(300,40));
                DataProcessingChoose2.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
                    public void itemStateChanged(ItemEvent e) {
                        System.out.println("你选择了："+DataProcessingChoose2.getSelectedItem()+"是第"+ (DataProcessingChoose2.getSelectedIndex()+1)+"个选项");
                        if(DataProcessingChoose2.getSelectedItem()=="  样本均衡"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("进行分类任务时，如果因变量不同类别的样本数量不均衡时，会严重影响模型训练。比如说对于一个二分类问题，某一类别有995个数据，另一类别有5个数据时，此时属于严重的数据样本分布不均衡，很难从中提取规律，所以当发现样本不均衡时，需要做样本均衡处理，增加样本量较少的类别样本或减少样本量较多的类别样本，从而使得因变量不同类别的样本数量相差不大。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：至少两项定量变量。\n" +
                                    "输出：增加样本量较少的类别样本或减少样本量较多的类别样本。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("样本均衡不支持对存在空值的变量进行处理，需要提前处理空值。\n" +
                                    "样本均衡仅支持在客户端进行下载使用。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("（1）过采样\n" +
                                    "当数据不平衡的时，比如对于一个只用0和1的二分类问题，样本标签1有995个数据，样本标签0有5个数据时，为了保持样本数目的平衡，可以选择增加或通过算法生成标签0的数据量，这个过程就叫做上采样，也叫过采样。\n" +
                                    "（2）下采样\n" +
                                    "当数据不平衡的时，比如对于一个只用0和1的二分类问题，样本标签1有995个数据，样本标签0有5个数据时，为了保持样本数目的平衡，可以选择减少或通过算法减少标签1的数据量，这个过程就叫做下采样，也叫欠采样。\n" +
                                    "（3）组合采样\n" +
                                    "结合上采样和下采样的方法，为了保持样本数目的平衡，可以选择通过算法减少或生成不均衡标签的数据量。");
                            jta.append("\n");
                        }
                        else if(DataProcessingChoose2.getSelectedItem()=="  数据标准化"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("数据标准化包括去量纲化和一致化。去量纲化是指不同指标之间由于量纲不同以致于其不具可比性，故首先需将指标进行无量纲化，消除量纲影响后再进行接下来的分析。例如，某个变量的数值在1-10之间，而另一个变量的数值范围在100-1000之间，此时若进行综合评价，从数值的角度，很有可能数值变化范围大的变量，它的绝对作用就会较大，所占的比重较大。一致性是指将指标作用方向一致化，例如我们在评价多个不同指标的作用时，正向指标是数值越大越好，负向指标是数值越小越好，如果同时评价这两类指标的综合作用，由于他们的作用方向不同，不能将指标作用直接相加，此时我们就需要对逆指标进行一致化处理。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：一项或以上定量变量。\n" +
                                    "输出：新生成标准化后的变量。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("数据标准化不支持对存在空值的变量进行处理，需要提前处理空值。\n" +
                                    "当指标中既存在正向指标又存在负向指标的时候，为了统一处理公式，最好只使用正向指标处理-负向指标处理。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("（1）min-max标准化\n" +
                                    "（2）z-score标准化\n" +
                                    "（3）归一化\n" +
                                    "（4）中心化\n" +
                                    "（5）正项指标处理\n" +
                                    "（6）负向指标处理");
                            jta.append("\n");
                        }
                        else if(DataProcessingChoose2.getSelectedItem()=="  数据统计特征描述"){
                            jta.setText("");
                            jta.append("\n");
                            jta.append("1.作用");
                            jta.append("\n");
                            jta.append("k 近邻算法，是将 K 个最近邻实例进行平均处理预测的一种有监督算法。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("2、输入输出描述");
                            jta.append("\n");
                            jta.append("输入：自变量 X 为 1 个或 1 个以上的定类或定量变量，因变量 Y 为一个定量变量。\n" +
                                    "输出：模型输出的结果值及模型预测效果。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("3、注意事项");
                            jta.append("\n");
                            jta.append("若在训练划分时对数据进行洗牌打乱数据顺序，会导致 K 近邻具有随机性，每次运算的结果不一样。若需要保存本次训练模型，需要使用。\n" +
                                    "K 近邻的参数修改需要使用。");
                            jta.append("\n");
                            jta.append("\n");
                            jta.append("4、模型理论");
                            jta.append("\n");
                            jta.append("KNN做回归和分类的主要区别在于最后做预测时候的决策方式不同。KNN做分类预测时，一般是选择多数表决法，即训练集里和预测的样本特征最近的K个样本，预测为里面有最多类别数的类别。KNN做回归时，一般是选择平均法，即最近的K个样本的样本输出的平均值作为回归预测值。但它们的理论是一样的。\n" +
                                    "模型介绍：\n" +
                                    "K近邻算法，即是给定一个训练数据集，对新的输入实例，在训练数据集中找到与该实例最邻近的K个实例，这K个实例的平均值作为预测值。\n" +
                                    "看一个最简单的例子，当k=1时，即新实例的类别由里它最近的训练实例的值决定。当k=3时，预测值为最近三个训练样本的值求平均；当k=5时，预测值为最近三个训练样本的值求平均。这里面“最近距离”的定义，是由距离公式求出来的值。\n" +
                                    "K 值的选取：\n" +
                                    "如何选择一个最佳的 K 值取决于数据。一般情况下，在分类时较大的 K 值能够减小噪声的影响，但会使类别之间的界限变得模糊。一个较好的 K 值能通过各种启发式技术来获取。\n" +
                                    "在二元（两类）分类问题中，选取 k 为奇数有助于避免两个分类平票的情形。在此问题下，选取最佳经验 k 值的方法是自助法(Bootstrap)。\n" +
                                    "距离公式：\n" +
                                    "这里面“最近距离”来的定义，是由距离公式求出来的值。距离度量除了常用的欧式距离，还可以使用曼哈顿距离和切比雪夫距离。\n" +
                                    "求解算法：\n" +
                                    "既然我们要找到 k 个最近的邻居来做预测，那么我们只需要计算预测样本和所有训练集中的样本的距离，然后计算出最小的 k 个距离即可，接着多数表决，很容易做出预测。这个方法的确简单直接，在样本量少，样本特征少的时候有效。但是在实际运用中很多时候用不上，为什么呢？因为我们经常碰到样本的特征数有上千以上，样本量有几十万以上，如果我们这要去预测少量的测试集样本，算法的时间效率很成问题。因此，这个方法我们一般称之为蛮力实现。比较适合于少量样本的简单模型的时候用。\n" +
                                    "蛮力实现在特征多，样本多的时候很有局限性，我们可以选择 KD 树或者球树来实现。\n" +
                                    "\n" +
                                    "#");
                            jta.append("\n");
                        }


//                }
                    }
                });
                DataProcessingChoose2.setFont(new Font("微软雅黑", Font.BOLD, 13));
                DataProcessingChoose2.setPreferredSize(new Dimension(300,40));

                Box bBoxLeft2 = Box.createVerticalBox();
                bBoxLeft2.add(Box.createGlue());
//                 bBoxLeft2.add(PredictChoose);
//                 bBoxLeft2.add(ReturnChoose);
//                 bBoxLeft2.add(TimeSeriesChoose);
//        bBoxLeft.add(MachineLearningChoose);
//                 bBoxLeft2.add(GraphtheoryChoose);
//                 bBoxLeft2.add(StatisticalmodelingChoose);
//                 bBoxLeft2.add(MachineLearningRegressChoose);
//                 bBoxLeft2.add(DataProcessingChoose);
                bBoxLeft2.add(EvaluateChoose2);
                bBoxLeft2.add(GraphtheoryChoose2);
                bBoxLeft2.add(StatisticalmodelingChoose2);
                bBoxLeft2.add(MachineLearningRegressChoose2);
                bBoxLeft2.add(DataProcessingChoose2);
                jpp.add(bBoxLeft2);

                inerboox.add(jpp);//1
                inerboox.add(jta);//2
                jff.add(inerboox);
            }
        });
        jb2.setFont(new Font("微软雅黑", Font.BOLD, 12));
//                boxleft.add(jb2);
//                leftPanel.add(boxleft);
        leftPanel.add(jb2);
        leftPanel.add(jp2);
//        String[] listData110 = new String[]{" 任务清单"};
//        JComboBox TaskList = new JComboBox(listData110);//下拉选择框
        TaskList.setPreferredSize(new Dimension(400,40));
        TaskList.setRenderer(new CustomListCellRenderer()); // 设置自定义渲染器
//        String[] listData111 = new String[]{" 结果缓存管理"};
//        JComboBox ResultsCache = new JComboBox(listData111);//下拉选择框
        ResultsCache.setPreferredSize(new Dimension(400,40));
        ResultsCache.setRenderer(new CustomListCellRenderer()); // 设置自定义渲染器
        zt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zt.isSelected()) {
                    System.out.println("选中状态：增添任务清单已选中");
                    AllowedtoAdd=1;
                    //开始记录点击的事件
//                    TaskList.addItem(TaskListed.get(1));
                } else {
                    System.out.println("未选中状态：增添任务清单未选中");
                    AllowedtoAdd=0;
                }
            }
        });
//                leftPanel.add(TaskList);
        JButton jb=new JButton("导入数据表格");
        jb.setFont(new Font("微软雅黑", Font.BOLD, 16));
        bb.add("python");
        bb.add("D:\\pythonProject\\function1.py");
        jb.addActionListener(new ActionListener() { // 下一步的按钮动作
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                if(arr21.size()==0){
                if(bb.size()>2){
                    for(int i=bb.size()-1;i>1;--i){
                        bb.remove(i);
                    }
                    arr3.clear();
                }
//                }
                index=1;

                FileDialog fileDialog = new FileDialog(frame,"open",FileDialog.LOAD);
                fileDialog.setVisible(true);

                //获取用户选择的图片路径以及名称
                String dir = fileDialog.getDirectory();
                String fileName = fileDialog.getFile();
                file=new File(dir,fileName);
//                System.out.println("dir"+dir);

//                JFileChooser chooser = new JFileChooser();
//                chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//                chooser.showDialog(new JLabel(), "选择");
//                file = chooser.getSelectedFile();
                //核心代码
                try {
                    ArrayList<String> a = new ArrayList<String>();
                    a.add("python");
                    if(name=="  迪杰斯特拉算法"){
                        a.add("D:\\pythonProject\\getdata.py");
                    } else if (name=="  最小生成树算法") {
                        a.add("D:\\pythonProject\\getdata.py");
                    } else
                        a.add("D:\\pythonProject\\getdata1.py");
                    a.add(file.getAbsoluteFile().toString());
                    System.out.println(file.getAbsoluteFile().toString());
                    stack.push(file.getAbsoluteFile().toString());
                    if(bb.size()!=2)
                        bb.set(2,file.getAbsoluteFile().toString());
                    else
                        bb.add(file.getAbsoluteFile().toString());
                    System.out.println("bb也在这里："+bb);
//                    bb.add("  优劣解距离法");
                    System.out.println("最终使用方法为："+name);
                    bb.add(name);
//                    System.out.println("背包标志的值为：                                                        "+beibao);
                    if(migong==1){//单独执行
//                        bb.add(positions.get(0));
//                        bb.add(positions.get(1));
                        bb.add(positions.get(positions.size()-2));
                        bb.add(positions.get(positions.size()-1));
                        System.out.println(bb.get(4));
                        System.out.println("特殊bb在这里："+bb);
                        try {
//                        System.out.println(bb);
                            Process proc = Runtime.getRuntime().exec(bb.toArray(new String[0]));// 执行py文件
                            int res = proc.waitFor();
//                        System.out.println(res);
                            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "gb2312"));
                            String line = null;
                            while ((line = in.readLine()) != null) {
//                            System.out.println(line);
                                if(line!=null){
                                    arr3.add(line);
                                }
                            }
                            System.out.println("本次结果的arr3等于："+arr3);
                            in.close();
                            proc.waitFor();

                            jjb.setText("");
                            jjb.setFont(new Font("宋体", Font.BOLD, 16));
                            jjb.setLineWrap(true);
//                    JPanel jjjb=new JPanel();
//                    jjjb.setPreferredSize(new Dimension(500,500));
                            for(int i=0;i<arr3.size();++i){
//                        jjb.setText(arr3.get(i));
                                jjb.append(arr3.get(i));
                                jjb.append("\n");
                            }
                            System.out.println(jjb.getText());
                            JScrollPane pane1 = new JScrollPane(jjb,
                                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//                    jjjb.add(pane2);
                            cardPanels2.removeAll();
                            cardPanels2.add(pane1);
                            JButton jttb=new JButton("保存结果");
                            jttb.setFont(new Font("微软雅黑", Font.BOLD, 16));
                            jttb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String dir1="D:\\res_photo";
                                    filenumber++;
                                    String nname=name+String.valueOf(filenumber)+".txt";
                                    System.out.println("nname"+nname);
                                    System.out.println(jjb.getText());
                                    String p=jjb.getText();
                                    try {
//                                FileOutputStream f = new FileOutputStream("d:\\test.txt");
//                                System.out.println(new File(dir1,nname).getAbsolutePath());
                                        FileOutputStream f = new FileOutputStream(new File(dir1,nname).getAbsolutePath());
                                        OutputStreamWriter s = new OutputStreamWriter(f,"UTF-8");
                                        s.write(p);
                                        s.close();
                                    } catch (FileNotFoundException ex) {
                                        ex.printStackTrace();
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            });
                            JButton jttb2=new JButton("打开文件");
                            jttb2.setFont(new Font("微软雅黑", Font.BOLD, 16));
                            jttb2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ex2) {
                                    try {
                                        Desktop.getDesktop().open(new File("D:\\res_photo"));
                                    } catch (IOException e2) {
                                        throw new RuntimeException(e2);
                                    }
                                }
                            });
                            cardPanels2.add(jttb);
                            cardPanels2.add(jttb2);
                            JPanel jp2=new JPanel();
                            JLabel jl3=new JLabel("结果分析",SwingConstants.CENTER);
                            jl3.setPreferredSize(new Dimension(440,30));
                            jl3.setFont(new Font("微软雅黑", Font.BOLD, 15));
                            jp2.add(jl3);
                            cardPanels2.setPreferredSize(new Dimension(400,508));
                            jp2.setPreferredSize(new Dimension(400,508));
                            jp2.add(cardPanels2);
                            JFrame jg= new JFrame("结果分析");
                            jg.setSize(450,550);
                            jg.setLocation(650, 200);
                            jg.add(jp2);
                            jg.setVisible(true);
                        } catch (IOException ee) {
                            ee.printStackTrace();
                        } catch (InterruptedException ee) {
                            ee.printStackTrace();
                        }
                        return;
                    }
                    Process proc = Runtime.getRuntime().exec(a.toArray(new String[0]));// 执行py文件
                    int res=proc.waitFor();
                    BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"gb2312"));
                    String line = null;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                        if(line!=null){
                            arr1=line.toString().split(",");
                            System.out.println(arr1.length);
                            arrlength=arr1.length;
                        }
                    }
                    in.close();
                    proc.waitFor();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(arr1.length);
                Box bBoxCentered = Box.createVerticalBox();

                chkbox.clear();arr21.clear();arr22.clear();
                for(int v=0;v<arr1.length;++v){

                    chkbox.add(new JCheckBox(arr1[v].toString()));
                    chkbox.get(v).setPreferredSize(new Dimension(220,30));
                    chkbox.get(v).setFont(new Font("楷体", Font.BOLD, 16));
                    bBoxCentered.add(chkbox.get(v));
                    int finalV = v;
                    chkbox.get(v).addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            if(index==1){
                                arr21.add(chkbox.get(finalV).getText());
                                System.out.println("arr21:"+arr21);
                            }
                            if(index==2){
                                arr22.add(chkbox.get(finalV).getText());
                                System.out.println("arr22:"+arr22);
                            }
                        }
                    });
                }
                cardPanel2.removeAll();
                cardPanel2.add(bBoxCentered);
                System.out.print(1);
                card.last(cardpanel);
            }

        });
//        boxx.add(jb);
        JPanel sp=new JPanel();
        sp.setPreferredSize(new Dimension(400,30));
        Box bButton=Box.createVerticalBox();
//        bButton.add(jb2);
//        bButton.add(sp);
        bButton.add(zt);
        bButton.add(TaskList);
//        bButton.add(sp);
        bButton.add(ResultsCache);
//        bButton.add(sp);
//        bButton.add(TaskList);
        leftPanel.add(bButton);
        leftPanel.add(boxx);

        //bBoxCenter
        //由点击事件触发另一个界面
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(540, 600));

        cardPanel2 = new JPanel();
        cardPanel2.setPreferredSize(new Dimension(220,508));
        cardPanel1 = new JPanel();//空白卡片1
        //card2
        //card1
        JPanel white=new JPanel();
        cardPanel1.add(white);
        cardpanel.add(cardPanel1);
        cardpanel.add(cardPanel2);
        JPanel bBoxCenterbase = new JPanel();
        bBoxCenterbase.add(cardpanel);
        bBoxCenter.add(bBoxCenterbase);
//        bBoxCenter.add(cardpanel);//将卡片1置为空白页，并最开始的时候显示;改为cardPanel2将显示内容

        JLabel jl2=new JLabel("组别与标签选择",SwingConstants.CENTER);
        jl2.setPreferredSize(new Dimension(540,100));
        jl2.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jlll=new JLabel("组别："+num,SwingConstants.CENTER);
//设置一个button装入jlll的文字，点击之后可以切换组别；暂时可以不做按钮值的更新
        JButton jlll2=new JButton("组别："+num);
        jlll2.setFont(new Font("黑体", Font.BOLD, 14));
        jlll2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(num==2&&index2==2){
                    index2=0;
                }
                if(num==1){
                    if(bb.indexOf("#")==-1){
                        JOptionPane.showMessageDialog(null,"尚未确认当组标签，请确认后再切换组别");
                        return;
                    }
                    num=2;
                    //释放1的资源
                    //取消画勾
                    for(int i=0;i<arr1.length;++i){
                        chkbox.get(i).setSelected(false);
                    }
                    arr21.clear();
                }else if(num==2){
                    //下面的撤了，容易坑人
//                    if(bb.indexOf("#")+1>=bb.size()&&Zeroingin==0){
//                        JOptionPane.showMessageDialog(null,"尚未确认当组标签，请确认后再切换组别");
//                        return;
//                    }
                    num=1;
                    jlll2.setText("组别："+num);
                    //释放2的资源
                    for(int i=0;i<arr1.length;++i){
                        chkbox.get(i).setSelected(false);
                    }
                    arr22.clear();
                }
//                jlll.setText("组别："+num);
                jlll2.setText("组别："+num);
                index=num;
            }
        });
        centerPanel.add(jl2);
        JButton jsee=new JButton("数据预览");
        jsee.setFont(new Font("黑体", Font.BOLD, 14));
        jsee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                File filesee = new File("/Users/maojiawei/Desktop/备份文件/备忘录.txt");//"C:\Users\maojiawei\Desktop\备份文件\备忘录.txt"
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) {
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
//        centerPanel.add(jlll);
        centerPanel.add(jlll2);
        centerPanel.add(jsee);

        JPanel fatherspace=new JPanel();
        fatherspace.setPreferredSize(new Dimension(420,350));
        Box space = Box.createHorizontalBox();
        spacer=new JPanel();
        spacer.setPreferredSize(new Dimension(90,508));
        JButton jbb=new JButton("确认当组标签");
        jbb.setFont(new Font("微软雅黑", Font.BOLD, 16));
        jbb.addActionListener(new ActionListener() {//记录arr3并输出作为当页的结果
            @Override
            public void actionPerformed(ActionEvent e) {
                long stime = System.currentTimeMillis();
                System.out.println("1000000");
//                if(bb.indexOf("#")!=-1&&bb.size()-1==bb.indexOf("#")){//有第一组变量
//                    JOptionPane.showMessageDialog(null,"1组标签已确认，可以点击“组别”按钮以切换组别");
//                }
//                if(bb.indexOf("#")!=-1&&bb.indexOf("#")+1<bb.size()){//有第二组变量
//                    System.out.println("我很难受："+bb);
//                    JOptionPane.showMessageDialog(null,"2组标签已确认，开始分析？");
//                }
                if (index == 1) {
                    System.out.println("最终输出：1组最终值" + arr21);//建立一个返回给python值的端口
                    for (String m : arr21) {
                        bb.add(m);
                    }
                    bb.add("#");
                    index2=1;
                }

                if (index == 2) {
//                    item++;
//                    if(bb.size()>4&&(item%2==0)){
//                        for(int i=bb.size()-1;i>3;--i){
//                            bb.remove(i);
//                        }
//                    }
                    index2=0;
                    //点击事件生成弹窗
//                    Frame frame = new Frame("这里测试Dialog");
//                    //1.创建两个对话框Dialog对象，一个模式的，一个非模式的
//                    Dialog d1 = new Dialog(frame, "模式对话框", true);

                    System.out.println("最终输出：2组最终值" + arr22);//建立一个返回给python值的端口
                    if(!arr22.isEmpty()){
                        for (String m : arr22) {
                            bb.add(m);
                        }
                        bb.add("#");
                    }
                    if(beibao==1){
                        bb.add(weight);
                        bb.add("#");
                    }
                    System.out.println("bb在这里："+bb);
//                    System.out.println("hh");
                    try {
//                        System.out.println(bb);
                        Process proc = Runtime.getRuntime().exec(bb.toArray(new String[0]));// 执行py文件
                        int res = proc.waitFor();
//                        System.out.println(res);
                        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "gb2312"));
                        String line = null;
                        while ((line = in.readLine()) != null) {
//                            System.out.println(line);
                            if(line!=null){
                                arr3.add(line);
                            }
                        }
                        System.out.println("本次结果的arr3等于："+arr3);
                        in.close();
                        proc.waitFor();
                    } catch (IOException ee) {
                        ee.printStackTrace();
                    } catch (InterruptedException ee) {
                        ee.printStackTrace();
                    }
                    if(arr3.size()==0){
                        if(name=="  简单散点图"){
                            JOptionPane.showMessageDialog(null,"导入表格存在缺失值，请补充后再重试");
                            Zeroingin=1;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"请检查导入表格数据是否符合算法要求");
                            Zeroingin=1;
                        }
                        if(bb.size()>2){
                            for(int i=bb.size()-1;i>3;--i){
                                bb.remove(i);
                            }
                            arr3.clear();
                        }
                        return;
                    }
                    //如果正常运行，出队列
                    String removedElement = queue.poll();
                    System.out.println("移除的元素：" + removedElement);
                    TaskList.removeItem(removedElement);
                    //如果正常运行，则存入缓存管理中
                    //增加新的东西
                    String nname=name+String.valueOf(resultnumber);
                    if(resultsqueue.size()==3) {//如果等于，需要出队列一个元素才能增加元素
                        resultsqueue.add(nname.toString());
//                        System.out.println("该出栈了00000000000000000000000000000000000");
                        String removedElement2 = resultsqueue.poll();
//                        System.out.println(removedElement2+"11111111111111111111111111");
                        String removedElement22 = removedElement2+".txt";
                        System.out.println("移除的元素：" + removedElement2);
                        ResultsCache.removeItem(removedElement2);//对于选项出队列

                        String dir0 = "D:\\res_photo";
                        System.out.println("移除的元素：" + removedElement22);
                        // 删除溢出的文件
                        File file1 = new File(dir0,removedElement22);
                        // 检查文件是否存在
                        if (file1.exists()) {
                            // 删除文件
                            boolean deleted = file1.delete();

                            if (deleted) {
                                System.out.println("文件删除成功");
                            } else {
                                System.out.println("文件删除失败");
                            }
                        } else {
                            System.out.println("文件不存在");
                        }
                    }


                    resultsqueue.add(nname);
//                    resultnumber++;
                    ResultsCache.addItem(nname);
                    //存储在本地用于打开
                    String dir1="D:\\res_photo";
                    String nname2=name+String.valueOf(resultnumber)+".txt";
//                    System.out.println("nname"+nname);
//                    System.out.println(jjb.getText());
                    jjb.setText("");
                    for(int i=0;i<arr3.size();++i){
//                        jjb.setText(arr3.get(i));
                        jjb.append(arr3.get(i));
                        jjb.append("\n");
                    }
                    String p=jjb.getText();
                    System.out.println(nname2+"写入的是："+p);
                    try {
//                                FileOutputStream f = new FileOutputStream("d:\\test.txt");
//                                System.out.println(new File(dir1,nname).getAbsolutePath());
                        FileOutputStream f = new FileOutputStream(new File(dir1,nname2).getAbsolutePath());
                        OutputStreamWriter s = new OutputStreamWriter(f,"UTF-8");
                        s.write(p);
                        s.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    resultnumber++;
//                    ResultsCache.addItemListener(new ItemListener() {// 打开对应的内容
//                        public void itemStateChanged(ItemEvent e) {
//                            if(e.getStateChange() == ItemEvent.SELECTED){
//                                //将结果存储在本地，如果出队列，将内容删除，表示暂时缓存
//                                System.out.println("你选择了：" + ResultsCache.getSelectedItem() + "是第" + (ResultsCache.getSelectedIndex() + 1) + "个选项");
//                                String name = ResultsCache.getSelectedItem().toString() + ".txt";
//                                String dir0 = "D:\\res_photo";
//                                System.out.println("准备打开的文件名为：" + name);
//                                Desktop desktop = Desktop.getDesktop();
//                                File fileinter = new File(dir0, name);
//                                if (fileinter.exists()) {
//                                    try {
//                                        desktop.open(fileinter);
//                                    } catch (IOException ex) {
//                                        throw new RuntimeException(ex);
//                                    }
//                                }
//                            }
////                            if(bb.size()>2)
////                                bb.set(3,name);
////                }
//                        }
//                    });

                    //是否为特殊情况
//                    ResultsCache.addItemListener(new ItemListener() {
//                        @Override
//                        public void itemStateChanged(ItemEvent e) {
//                            if (e.getStateChange() == ItemEvent.SELECTED) {
//                                // 将结果存储在本地，如果出队列，将内容删除，表示暂时缓存
//                                System.out.println("你选择了：" + ResultsCache.getSelectedItem() + "是第" + (ResultsCache.getSelectedIndex() + 1) + "个选项");
//                                String name = ResultsCache.getSelectedItem().toString() + ".txt";
//                                String dir0 = "D:\\res_photo";
//                                System.out.println("准备打开的文件名为：" + name);
//                                Desktop desktop = Desktop.getDesktop();
//                                File fileinter = new File(dir0, name);
//                                if (fileinter.exists()) {
//                                    try {
//                                        desktop.open(fileinter);
//                                    } catch (IOException ex) {
//                                        throw new RuntimeException(ex);
//                                    }
//                                }
//                            }
//                        }
//                    });
                    ResultsCache.addItemListener(new ItemListener() {// 添加选中状态改变的监听器
                        public void itemStateChanged(ItemEvent e) {
                            if(e.getStateChange() == ItemEvent.SELECTED&&ffff==1){
                                // 将结果存储在本地，如果出队列，将内容删除，表示暂时缓存
                                System.out.println("你选择了：" + ResultsCache.getSelectedItem() + "是第" + (ResultsCache.getSelectedIndex() + 1) + "个选项");
                                String name = ResultsCache.getSelectedItem().toString() + ".txt";
                                String dir0 = "D:\\res_photo";
                                System.out.println("准备打开的文件名为：" + name);
                                Desktop desktop = Desktop.getDesktop();
                                File fileinter = new File(dir0, name);
                                if (fileinter.exists()) {
                                    try {
                                        desktop.open(fileinter);
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                ffff=0;
                            }else {
                                ffff=1;
                            }
                        }
                    });


                    if(special==1){
                        System.out.println("name:"+name);
//                        String dir0="D:\\res_photo";
//                        String fileName0 = "";
//                        switch (name){
//                            case "  频数柱状图":
//                                fileName0="BarChart.png";
//                                break;
//                            case "  频数扇形图":
//                                fileName0="PieChart.png";
//                                break;
//                            case "  散点图":
//                                fileName0="PieChart.png";
//                                break;
//                        }
//                        //打开图片
//                        File file0=new File(dir0,fileName0);
//                        Desktop desktop = Desktop.getDesktop();
//                        try {
//                            if (file0.exists()) desktop.open(file0);
//                        } catch (IOException ex) {
//                            throw new RuntimeException(ex);
//                        }
                        //使用一次恢复
                        special=0;
//                        card2.first(cardpanels);
//                        System.out.println(1);
//                        JOptionPane.showMessageDialog(null,"请检查导入表格数据是否符合算法要求");
//                        if(bb.size()>2){
//                            for(int i=bb.size()-1;i>3;--i){
//                                bb.remove(i);
//                            }
//                            arr3.clear();
//                        }
//                        return;

                    }
//                    JTextArea jjb=new JTextArea(20,39);
                    jjb.setText("");
                    jjb.setFont(new Font("宋体", Font.BOLD, 16));
                    jjb.setLineWrap(true);
//                    JPanel jjjb=new JPanel();
//                    jjjb.setPreferredSize(new Dimension(500,500));
                    for(int i=0;i<arr3.size();++i){
//                        jjb.setText(arr3.get(i));
                        jjb.append(arr3.get(i));
                        jjb.append("\n");
                    }
                    System.out.println(jjb.getText());
                    JScrollPane pane1 = new JScrollPane(jjb,
                            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//                    jjjb.add(pane2);
                    cardPanels2.removeAll();
                    cardPanels2.add(pane1);
                    JButton jttb=new JButton("保存结果");
                    jttb.setFont(new Font("微软雅黑", Font.BOLD, 16));
                    jttb.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String dir1="D:\\res_photo";
                            filenumber++;
                            String nname=name+String.valueOf(filenumber)+".txt";
                            System.out.println("nname"+nname);
                            System.out.println(jjb.getText());
                            String p=jjb.getText();
                            try {
//                                FileOutputStream f = new FileOutputStream("d:\\test.txt");
//                                System.out.println(new File(dir1,nname).getAbsolutePath());
                                FileOutputStream f = new FileOutputStream(new File(dir1,nname).getAbsolutePath());
                                OutputStreamWriter s = new OutputStreamWriter(f,"UTF-8");
                                s.write(p);
                                s.close();
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    JButton jttb2=new JButton("打开文件");
                    jttb2.setFont(new Font("微软雅黑", Font.BOLD, 16));
                    jttb2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ex2) {
                            try {
                                Desktop.getDesktop().open(new File("D:\\res_photo"));
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                    });
                    cardPanels2.add(jttb);
                    cardPanels2.add(jttb2);
//                    cardPanels2.add(jjjb);
                    card2.last(cardpanels);
                    System.out.println("第二个我"+arr3);

//                    item++;
//                    if(bb.size()>2){
//                        for(int i=bb.size()-1;i>3;--i){
//                            bb.remove(i);
//                        }
//                        arr3.clear();
//                    }
                    //图片显示板块
                    //图片显示板块
                    String dir0="D:\\res_photo";
                    String fileName0 = "";
                    String fileName1 = "";
                    String fileName2 = "";
                    String fileName3="";String fileName4="";String fileName5="";
                    System.out.println("name"+name);
                    switch (name){
                        case "  CRITIC定权"://不行
                            fileName0="CRITIC_权重.png";
                            break;
                        case "  熵权法"://不行
                            fileName0="熵权法权重.png";
                            break;
                        case "  优劣解距离法"://不行
                            fileName0="熵权法权重.png";
                            break;
                        case "  主成分分析法"://先1后二
                            fileName0="PCA_碎石图.png";
                            break;
                        case "  灰色预测"://没做
                            fileName0="GM11_model.png";
                            break;
                        case "  线性回归"://可以
                            fileName0="linear_regression.png";
                            fileName1="compare.png";
                            break;
                        case "  多项式回归"://可以
                            fileName0="poly_regression.png";
                            fileName1="compare.png";
                            System.out.println("fileName0"+fileName0);
                            break;
                        case "  指数回归"://没做
                            fileName0="exp_regression.png";
                            break;
                        case "  ARIMA模型":
                            fileName0="ARIMA_原数据.png";
                            //下面的图片我显示不出来，所以没有做显示的代码，你想要显示的话可以酌情修改显示图片的代码
                            fileName1="ARIMA_自相关图.png";
                            fileName2="ARIMA_偏自相关图.png";
                            fileName3="ARIMA_比较图.png";
                            fileName4="ARIMA_残差图.png";
                            fileName5="ARIMA_预测图.png";
                            break;
                    }
//                    if((fileName0)!=""){
//                    //打开一个文件对话框
//                    FileDialog fileDialog = new FileDialog(frame,"open",FileDialog.LOAD);
//                    fileDialog.setVisible(true);
//
//                    //获取用户选择的图片路径以及名称
//                    String dir = fileDialog.getDirectory();
//                    String fileName = fileDialog.getFile();
//                    System.out.println(dir+","+fileName);
//                    System.out.println("filename0:"+fileName0);

                    //如果有图片，显示图片弹窗
                    if(fileName0!=""&&arr3.size()!=0) {
                        JFrame jf=new JFrame();
                        jf.setLocation(450, 200);
                        jf.setSize(1000,1000);
                        JPanel jp=new JPanel();
                        File file0=new File(dir0,fileName0);
                        jf.setSize(1000, 550);
                        Desktop desktop = Desktop.getDesktop();
                        try {
//                            file = new File("/Users/maojiawei/Desktop/Gold2.xlsx");//"C:\Users\maojiawei\Desktop\Gold2.xlsx"
                            if (file0.exists()) desktop.open(file0);
//                            BufferedImage bufferedImage = ImageIO.read(file0);
//                            ImageIcon imageIcon = new ImageIcon(bufferedImage);
//                            imageIcon.setImage(imageIcon.getImage().getScaledInstance(800,400,Image.SCALE_DEFAULT));
//                            JLabel jLabel = new JLabel(imageIcon);
//                            jp.add(jLabel);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        if(fileName1!=""){
                            File file1=new File(dir0,fileName1);
                            try {
                                if (file1.exists()) desktop.open(file1);
//                                BufferedImage bufferedImage = ImageIO.read(file1);
//                                ImageIcon imageIcon = new ImageIcon(bufferedImage);
//                                imageIcon.setImage(imageIcon.getImage().getScaledInstance(1000,550,Image.SCALE_DEFAULT));
//                                JLabel jLabel = new JLabel(imageIcon);
//                                jp.add(jLabel);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        if(name.equals("  ARIMA模型")){
                            String[] a=new String[]{fileName2,fileName3,fileName4,fileName5};
                            for(String m:a)
                            {
                                File f=new File(dir0,m);
                                try {
                                    if (f.exists()) desktop.open(f);
//                                BufferedImage bufferedImage = ImageIO.read(f);
//                                ImageIcon imageIcon = new ImageIcon(bufferedImage);
//                                imageIcon.setImage(imageIcon.getImage().getScaledInstance(1000,550,Image.SCALE_DEFAULT));
//                                JLabel jLabel = new JLabel(imageIcon);
//                                jp.add(jLabel);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
//                        JScrollPane js = new JScrollPane(jp);
//                        jf.add(js);
//                        jf.setVisible(true);

//                        JPanel jp2=new JPanel();
//                        cardPanels2.setPreferredSize(new Dimension(400,508));
//                        jp2.setPreferredSize(new Dimension(400,508));
//                        jp2.add(cardPanels2);
////                        jg.add(pane1);
//                        jg.setPreferredSize(new Dimension(400,508));
//                        jg.add(jp2);
//                        jg.setVisible(true);
//                        image2 = new ImageIcon(new File(dir0, fileName0).getAbsolutePath());
//                        JDialog dialog2 = null;
//                        if (fileName1 != "") {
//                            image3 = new ImageIcon(new File(dir0, fileName1).getAbsolutePath());
//                            Image img = image3.getImage();
//                            img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
//                            image3.setImage(img);
//                            dialog2 = new JDialog(frame, "效果比较", true);
//                            dialog2.setSize(width + 15, height + 40);
//                            JLabel jlb = new JLabel();
//                            jlb.setIcon(image3);
//                            dialog2.add(jlb);
//                            jlb.setSize(600, height);
////                            dialog2.setVisible(true);
//                        } else
//                            image3 = null;
//                        System.out.println("图片地址为" + dir0 + fileName0);
//                        System.out.println("图片地址为" + new File(dir0, fileName0).getAbsolutePath());
//                        // image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
//                        Image img = image2.getImage();
//                        img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
//                        image2.setImage(img);
//                        JDialog dialog = new JDialog(frame, "显示图片", true);//设置弹出框体的特点
//                        dialog.setSize(width + 15, height + 40);
//                        JLabel jlb = new JLabel();
//                        jlb.setIcon(image2);
//                        dialog.add(jlb);
//                        jlb.setSize(600, height);
//                        dialog.setVisible(true);
//                        if (fileName1 != "")
//                            dialog2.setVisible(true);
//                        else
//                            dialog2.setVisible(false);

//                        image2 = new ImageIcon("D:\\res_photo\\linear_regression.png");
//                        // image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
//                        Image img = image2.getImage();
//                        img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
//                        image2.setImage(img);
//                        JDialog dialog = new JDialog(frame, "显示图片", true);//设置弹出框体的特点
//                        JLabel jlb = new JLabel();
//                        jlb.setIcon(image2);
//                        dialog.add(jlb);
//                        jlb.setSize(600, height);
//                        dialog.setVisible(true);
                    }
                    //显示文字弹窗弹窗
                    JPanel jp2=new JPanel();
                    JLabel jl3=new JLabel("结果分析",SwingConstants.CENTER);
                    jl3.setPreferredSize(new Dimension(440,30));
                    jl3.setFont(new Font("微软雅黑", Font.BOLD, 15));
                    jp2.add(jl3);
                    cardPanels2.setPreferredSize(new Dimension(400,508));
                    jp2.setPreferredSize(new Dimension(400,508));
                    jp2.add(cardPanels2);
//                        jg.add(pane1);
                    JFrame jg= new JFrame("结果分析");
                    jg.setSize(450,550);
                    jg.setLocation(650, 200);
//                    jg.removeAll();
                    jg.add(jp2);
                    jg.setVisible(true);
                    if(bb.size()>2){
                        for(int i=bb.size()-1;i>3;--i){
                            bb.remove(i);
                        }
                        arr3.clear();
                    }

//                    }

                }
                if(bb.indexOf("#")!=-1&&bb.size()-1==bb.indexOf("#")){//有第一组变量
                    JOptionPane.showMessageDialog(null,"1组标签已确认，可以点击“组别”按钮以切换组别");
                }
                //容易坑人，注释了
//                if(bb.indexOf("#")!=-1&&bb.indexOf("#")+1<bb.size()){//有第二组变量
//                    System.out.println("我很难受："+bb);
//                    JOptionPane.showMessageDialog(null,"2组标签已确认，开始分析？");
//                }
                long etime = System.currentTimeMillis();
                System.out.printf("执行时长：%d 毫秒.", (etime - stime));
//                if((etime - stime)>30000){
//                    JOptionPane.showMessageDialog(null,"程序运行时间过长，请重试");
//                    if(bb.size()>2){
//                        for(int i=bb.size()-1;i>3;--i){
//                            bb.remove(i);
//                        }
//                        arr3.clear();
//                    }
//                }
            }
        });
        space.add(spacer);
        space.add(bBoxCenter);
        fatherspace.add(space);
        centerPanel.add(fatherspace);
//        JButton jbbb=new JButton("切换变量组别");
//        jbbb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(num==1){
//                    num=2;
//                    //释放1的资源
//                    //取消画勾
//                    for(int i=0;i<arr1.length;++i){
//                        chkbox.get(i).setSelected(false);
//                    }
//                    arr21.clear();
//                }else if(num==2){
//                    num=1;
//                    //释放2的资源
//                    for(int i=0;i<arr1.length;++i){
//                        chkbox.get(i).setSelected(false);
//                    }
//                    arr22.clear();
//                }
//                jlll.setText("组别："+num);
//                index=num;
//            }
//        });
        Box jB=Box.createVerticalBox();
        JPanel jp22=new JPanel();
        jp22.setPreferredSize(new Dimension(20,30));
        jB.add(jp22);
        Box jpbox=Box.createHorizontalBox();
        jpbox.add(jb);
//        jB.add(jb);
        JButton jbc=new JButton("撤销");
        jbc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String top = stack.pop();
                System.out.println("Popped element: " + top);
                String peekedElement = stack.peek();
                //接下来使用倒数第二个表格
                if(bb.size()>2){
                    for(int i=bb.size()-1;i>1;--i){
                        bb.remove(i);
                    }
                    arr3.clear();
                }
                index=1;
//                    FileDialog fileDialog = new FileDialog(frame,"open",FileDialog.LOAD);
//                    fileDialog.setVisible(true);
                //获取用户选择的图片路径以及名称
//                    String dir = fileDialog.getDirectory();
//                    String fileName = fileDialog.getFile();
                file=new File(peekedElement);
                //核心代码
                try {
                    ArrayList<String> a = new ArrayList<String>();
                    a.add("python");
                    a.add("D:\\pythonProject\\getdata1.py");
//                        a.add(file.getAbsoluteFile().toString());
                    a.add(peekedElement);
                    if(bb.size()!=2)
                        bb.set(2,peekedElement);
                    else
                        bb.add(peekedElement);
                    bb.add(name);
                    if(migong==1){//单独执行
                        bb.add(positions.get(positions.size()-2));
                        bb.add(positions.get(positions.size()-1));
                        System.out.println(bb.get(4));
                        System.out.println("特殊bb在这里："+bb);
                        try {
//                        System.out.println(bb);
                            Process proc = Runtime.getRuntime().exec(bb.toArray(new String[0]));// 执行py文件
                            int res = proc.waitFor();
//                        System.out.println(res);
                            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "gb2312"));
                            String line = null;
                            while ((line = in.readLine()) != null) {
//                            System.out.println(line);
                                if(line!=null){
                                    arr3.add(line);
                                }
                            }
                            System.out.println("本次结果的arr3等于："+arr3);
                            in.close();
                            proc.waitFor();

                            jjb.setText("");
                            jjb.setFont(new Font("宋体", Font.BOLD, 16));
                            jjb.setLineWrap(true);
//                    JPanel jjjb=new JPanel();
//                    jjjb.setPreferredSize(new Dimension(500,500));
                            for(int i=0;i<arr3.size();++i){
//                        jjb.setText(arr3.get(i));
                                jjb.append(arr3.get(i));
                                jjb.append("\n");
                            }
                            System.out.println(jjb.getText());
                            JScrollPane pane1 = new JScrollPane(jjb,
                                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//                    jjjb.add(pane2);
                            cardPanels2.removeAll();
                            cardPanels2.add(pane1);
                            JButton jttb=new JButton("保存结果");
                            jttb.setFont(new Font("微软雅黑", Font.BOLD, 16));
                            jttb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String dir1="D:\\res_photo";
                                    filenumber++;
                                    String nname=name+String.valueOf(filenumber)+".txt";
                                    System.out.println("nname"+nname);
                                    System.out.println(jjb.getText());
                                    String p=jjb.getText();
                                    try {
//                                FileOutputStream f = new FileOutputStream("d:\\test.txt");
//                                System.out.println(new File(dir1,nname).getAbsolutePath());
                                        FileOutputStream f = new FileOutputStream(new File(dir1,nname).getAbsolutePath());
                                        OutputStreamWriter s = new OutputStreamWriter(f,"UTF-8");
                                        s.write(p);
                                        s.close();
                                    } catch (FileNotFoundException ex) {
                                        ex.printStackTrace();
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            });
                            JButton jttb2=new JButton("打开文件");
                            jttb2.setFont(new Font("微软雅黑", Font.BOLD, 16));
                            jttb2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ex2) {
                                    try {
                                        Desktop.getDesktop().open(new File("D:\\res_photo"));
                                    } catch (IOException e2) {
                                        throw new RuntimeException(e2);
                                    }
                                }
                            });
                            cardPanels2.add(jttb);
                            cardPanels2.add(jttb2);
                            JPanel jp2=new JPanel();
                            JLabel jl3=new JLabel("结果分析",SwingConstants.CENTER);
                            jl3.setPreferredSize(new Dimension(440,30));
                            jl3.setFont(new Font("微软雅黑", Font.BOLD, 15));
                            jp2.add(jl3);
                            cardPanels2.setPreferredSize(new Dimension(400,508));
                            jp2.setPreferredSize(new Dimension(400,508));
                            jp2.add(cardPanels2);
                            JFrame jg= new JFrame("结果分析");
                            jg.setSize(450,550);
                            jg.setLocation(650, 200);
                            jg.add(jp2);
                            jg.setVisible(true);
                        } catch (IOException ee) {
                            ee.printStackTrace();
                        } catch (InterruptedException ee) {
                            ee.printStackTrace();
                        }
                        return;
                    }
                    Process proc = Runtime.getRuntime().exec(a.toArray(new String[0]));// 执行py文件
                    int res=proc.waitFor();
                    BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"gb2312"));
                    String line = null;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                        if(line!=null){
                            arr1=line.toString().split(",");
                            System.out.println(arr1.length);
                            arrlength=arr1.length;
                        }
                    }
                    in.close();
                    proc.waitFor();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(arr1.length);
                Box bBoxCentered = Box.createVerticalBox();

                chkbox.clear();arr21.clear();arr22.clear();
                for(int v=0;v<arr1.length;++v){

                    chkbox.add(new JCheckBox(arr1[v].toString()));
                    chkbox.get(v).setPreferredSize(new Dimension(220,30));
                    chkbox.get(v).setFont(new Font("楷体", Font.BOLD, 16));
                    bBoxCentered.add(chkbox.get(v));
                    int finalV = v;
                    chkbox.get(v).addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            if(index==1){
                                arr21.add(chkbox.get(finalV).getText());
                                System.out.println("arr21:"+arr21);
                            }
                            if(index==2){
                                arr22.add(chkbox.get(finalV).getText());
                                System.out.println("arr22:"+arr22);
                            }
                        }
                    });
                }
                cardPanel2.removeAll();
                cardPanel2.add(bBoxCentered);
                System.out.print(1);
                card.last(cardpanel);
            }
        });
        jpbox.add(jbc);
        jB.add(jpbox);
//        jB.add(jbc);

        JPanel jp23=new JPanel();
        jp23.setPreferredSize(new Dimension(20,10));
        jB.add(jp23);
        Box jpbox2=Box.createHorizontalBox();
        jpbox2.add(jbb);
//        jB.add(jbb);
        JButton jbc2=new JButton("撤销");
        jbc2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bb.size()>3){//判断能不能删
                    int count=0;
                    for (String str : bb) {//判断几个#号
                        if (str.equals("#")) {
                            count++;
                        }
                    }

                    if(count==1){
                        int firstIndex = bb.indexOf("#");
                        bb.subList(4,firstIndex+1).clear();
                        System.out.println("bb是："+bb);
                        for(int i=0;i<arr1.length;++i){
                            chkbox.get(i).setSelected(false);
                        }
//                        arr21.clear();
//                        for()//撤销选中状态
                    }
                    if(count==2){
                        int cut = 0;
                        int lastIndex = -1;
// 从后往前遍历列表
                        for (int i = bb.size() - 1; i >= 0; i--) {
                            String element = bb.get(i);
                            if (element.equals("#")) {
                                cut++;
                                if (cut == 2) {
                                    lastIndex = i;
                                    break;
                                }
                            }
                        }
                        if (lastIndex != -1) {
                            bb.subList(lastIndex,bb.size()-1).clear();
                            System.out.println("从后往前数的第二个 '#' 号的位置：" + lastIndex);
                        } else {
                            System.out.println("未找到从后往前数的第二个 '#' 号");
                        }
                        System.out.println("bb是："+bb);
                        for(int i=0;i<arr1.length;++i){
                            chkbox.get(i).setSelected(false);
                        }
                        arr22.clear();
                    }

                }
            }
        });
        jpbox2.add(jbc2);
        jB.add(jpbox2);
//        jB.add(jbc2);


//        jB.add(jbbb);
        centerPanel.add(jB);

        //bBoxRight
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(440, 400));

//        CardLayout card2=new CardLayout();//卡片布局
//        JPanel cardPanels2 = new JPanel(card2);
//        JPanel cardpanels1 = new JPanel(card2);//空白卡片1

        Box bBoxRighted = Box.createVerticalBox();
//        JPanel cardPanels1=new JPanel();
        cardPanels1.setPreferredSize(new Dimension(400,30));
//        cardPanels2.setPreferredSize(new Dimension(400,508));
        cardpanels.add(cardPanels1);
//        cardpanels.add(cardPanels2);
        bBoxRight.add(cardpanels);//将卡片1置为空白页，并最开始的时候显示;改为cardPanels2将显示内容

        JLabel jl3=new JLabel("结果分析",SwingConstants.CENTER);
        jl3.setPreferredSize(new Dimension(440,30));
        jl3.setFont(new Font("微软雅黑", Font.BOLD, 15));
        rightPanel.add(jl3);
//        rightPanel.add(drawArea);
//        JScrollPane jsp=new JScrollPane();
//        jsp.add(bBoxRight);
//        jsp.add(drawArea);
        rightPanel.add(bBoxRight);
//        JButton jttb=new JButton("保存结果");
//        jttb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(jjb.getText());
//            }
//        });
//        rightPanel.add(jttb);
//        rightPanel.add(bBoxRight);

        bBox.add(leftPanel);
        JPanel border=new JPanel();
        border.setBackground(Color.DARK_GRAY);
        border.setPreferredSize(new Dimension(1,565));
        bBox.add(border);
        bBox.add(centerPanel);
        JPanel border2=new JPanel();
        border2.setBackground(Color.DARK_GRAY);
        border2.setPreferredSize(new Dimension(1,565));
        bBox.add(border2);
//        bBox.add(rightPanel);
//        jg.add(rightPanel);
//        jg.setVisible(true);
        frame.add(bBox);
        frame.pack();
//        frame.setBounds(300,300,925,585);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

    }
    static void useSkin() throws Exception {//皮肤
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel");
    }
    static void useTheme() throws Exception {//主题
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // 此处设置皮肤和主题
                SubstanceLookAndFeel
                        .setCurrentTheme("org.jvnet.substance.theme.SubstanceComplexTheme");
            }
        });
    }
    public static void main(String[] args) throws Exception {
        useSkin();//使用皮肤
        useTheme();//使用主题
        new Finalclass().init();
    }
}


