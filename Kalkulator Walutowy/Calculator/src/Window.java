
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.table.DefaultTableModel;

public class Window extends javax.swing.JFrame 
{

    public Window() 
    {
        initComponents();
        DefaultTableModel modelCurrency = (DefaultTableModel) currencyTab.getModel();
        DefaultTableModel modelMetal = (DefaultTableModel) metalTab.getModel();
        DefaultTableModel modelGPW = (DefaultTableModel) GPWTab.getModel();
        xml = new XMLparser();
        xml.downloadCurrency();
        xml.updateCurrency();
        xml.downloadMetal();
        xml.updateMetal();
        xml.downloadGPW();
        xml.updateGPW(); 
        df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        calc = new Calculator();
        for(int i=0; i<xml.currency.size(); i++)
        {
            if(i != 7)
                modelCurrency.addRow(new Object[]{xml.currency.get(i).tag, df.format(calc.caltulate(xml.currency.get(i), xml.currency.get(7), 1))});
            firstCurrencyList.addItem(xml.currency.get(i).tag);
            secondCurrencyList.addItem(xml.currency.get(i).tag);
        }    
        for(int i=0; i<xml.metal.size(); i++)
            modelMetal.addRow(new Object[]{xml.metal.get(i).name, df.format(calc.caltulate(xml.metal.get(i), xml.currency.get(7)))});
        for(int i=0; i<xml.GPW.size(); i++)
            modelGPW.addRow(new Object[]{xml.GPW.get(i).name, xml.GPW.get(i).current, xml.GPW.get(i).change});
        days=xml.currency.get(0).rates.size()-1;
        chartPanel.setLayout(new java.awt.BorderLayout());
        c=xml.currency.get(0);
        drawChart(c);  
        this.setTitle("Kalkulator walut");
        timePanel.setBackground(Color.lightGray);
        calcPanel.setBackground(Color.lightGray);
        listPanel.setBackground(Color.lightGray);
        radioButtom30.setBackground(Color.lightGray);
        radioButtom15.setBackground(Color.lightGray);
        radioButtom60.setBackground(Color.lightGray);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        dateTxt.setText("Dane pochodzą z dnia: " + xml.currency.get(0).update);
        this.setIconImage(new ImageIcon("D:\\Studia\\Informatyka\\Inżynieria oprogramowania\\Projekt\\Kalkulator Walutowy\\Calculator\\images.png").getImage());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeGroupRadioButtom = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        label1 = new java.awt.Label();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        currencyGroupRadioButtom = new javax.swing.ButtonGroup();
        chartPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        currencyTable = new javax.swing.JTable();
        listPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        currencyTab = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        metalTab = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        GPWTab = new javax.swing.JTable();
        calcPanel = new javax.swing.JPanel();
        firstCurrency = new javax.swing.JTextField();
        convertButtom = new javax.swing.JButton();
        firstCurrencyList = new javax.swing.JComboBox();
        secondCurrencyList = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        secondCurrency = new javax.swing.JTextField();
        clearButtom = new javax.swing.JButton();
        timePanel = new javax.swing.JPanel();
        radioButtom30 = new javax.swing.JRadioButton();
        radioButtom60 = new javax.swing.JRadioButton();
        radioButtom15 = new javax.swing.JRadioButton();
        dateTxt = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        update = new javax.swing.JMenu();
        appInfo = new javax.swing.JMenu();

        label1.setText("label1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        currencyTable.setAutoCreateColumnsFromModel(true);
        XMLparser xmll = new XMLparser();
        xmll.downloadCurrency();
        xmll.updateCurrency();
        currencyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Waluta", "Kurs"
            }
        ));
        currencyTable.setColumnSelectionAllowed(true);
        jScrollPane4.setViewportView(currencyTable);
        currencyTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chartPanelLayout.createSequentialGroup()
                .addGap(752, 752, 752)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chartPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(66, 66, 66))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setLabelFor(currencyTab);
        jLabel2.setText("Kursy walut");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setLabelFor(metalTab);
        jLabel3.setText("Ceny kruszców [za gram]");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setLabelFor(GPWTab);
        jLabel4.setText("Akcje GPW");

        currencyTab.setAutoCreateColumnsFromModel(true);
        currencyTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Waluta", "Kurs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        currencyTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currencyTabMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(currencyTab);
        currencyTab.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        metalTab.setAutoCreateColumnsFromModel(true);
        metalTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kruszec", "Cena"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(metalTab);
        metalTab.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        GPWTab.setAutoCreateColumnsFromModel(true);
        GPWTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indeks", "Wartość", "Zmiana"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GPWTab.setColumnSelectionAllowed(true);
        jScrollPane7.setViewportView(GPWTab);
        GPWTab.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listPanelLayout.createSequentialGroup()
                        .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(97, 97, 97))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(99, 99, 99))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(50, 50, 50))
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        firstCurrency.setToolTipText("");
        firstCurrency.setName("First currency"); // NOI18N
        firstCurrency.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstCurrencyKeyPressed(evt);
            }
        });

        convertButtom.setText("Przelicz");
        convertButtom.setToolTipText("Przelicz walute");
        convertButtom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                convertButtomMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kalkulator walut");

        secondCurrency.setEditable(false);

        clearButtom.setText("Wyczyść");
        clearButtom.setToolTipText("Wyczyć pola");
        clearButtom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtomMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout calcPanelLayout = new javax.swing.GroupLayout(calcPanel);
        calcPanel.setLayout(calcPanelLayout);
        calcPanelLayout.setHorizontalGroup(
            calcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calcPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(calcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calcPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(calcPanelLayout.createSequentialGroup()
                        .addGroup(calcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstCurrencyList, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(calcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(secondCurrencyList, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(calcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clearButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(convertButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62))))
        );
        calcPanelLayout.setVerticalGroup(
            calcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calcPanelLayout.createSequentialGroup()
                        .addComponent(secondCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(calcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstCurrencyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondCurrencyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(calcPanelLayout.createSequentialGroup()
                        .addGroup(calcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(convertButtom)
                            .addComponent(firstCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButtom)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        convertButtom.getAccessibleContext().setAccessibleName("Convert");
        firstCurrencyList.getAccessibleContext().setAccessibleName("First currency list");
        secondCurrencyList.getAccessibleContext().setAccessibleName("Second currency list");
        secondCurrency.getAccessibleContext().setAccessibleName("Second currency");

        timeGroupRadioButtom.add(radioButtom30);
        radioButtom30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioButtom30.setForeground(new java.awt.Color(255, 255, 255));
        radioButtom30.setText("30 dni");
        radioButtom30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioButtom30MouseClicked(evt);
            }
        });

        timeGroupRadioButtom.add(radioButtom60);
        radioButtom60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioButtom60.setForeground(new java.awt.Color(255, 255, 255));
        radioButtom60.setSelected(true);
        radioButtom60.setText("60 dni");
        radioButtom60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioButtom60MouseClicked(evt);
            }
        });

        timeGroupRadioButtom.add(radioButtom15);
        radioButtom15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioButtom15.setForeground(new java.awt.Color(255, 255, 255));
        radioButtom15.setText("15 dni");
        radioButtom15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtom15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout timePanelLayout = new javax.swing.GroupLayout(timePanel);
        timePanel.setLayout(timePanelLayout);
        timePanelLayout.setHorizontalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timePanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(radioButtom15)
                .addGap(232, 232, 232)
                .addComponent(radioButtom30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioButtom60)
                .addGap(25, 25, 25))
        );
        timePanelLayout.setVerticalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtom30)
                    .addComponent(radioButtom60)
                    .addComponent(radioButtom15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dateTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateTxt.setForeground(new java.awt.Color(255, 255, 255));
        dateTxt.setText("date");

        update.setText("Aktualizuj");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        menuBar.add(update);

        appInfo.setText("O aplikacji");
        appInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appInfoMouseClicked(evt);
            }
        });
        menuBar.add(appInfo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chartPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calcPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dateTxt.getAccessibleContext().setAccessibleName("Date currency");

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        DefaultTableModel modelCurrency = (DefaultTableModel) currencyTab.getModel();
        DefaultTableModel modelMetal = (DefaultTableModel) metalTab.getModel();
        DefaultTableModel modelGPW = (DefaultTableModel) GPWTab.getModel();
        JOptionPane.showMessageDialog(jDialog1,"Aktualizacja ukończona.");
        xml.currency.clear();
        xml.downloadCurrency();
        xml.updateCurrency();
        xml.metal.clear();
        xml.downloadMetal();
        xml.updateMetal();
        xml.GPW.clear();
        xml.downloadGPW();
        xml.updateGPW();
        for(int i=modelCurrency.getRowCount()-1; i>=0;i--)
            modelCurrency.removeRow(i);
        for(int i=modelMetal.getRowCount()-1; i>=0;i--)
            modelMetal.removeRow(i);
        for(int i=modelGPW.getRowCount()-1; i>=0;i--)
            modelGPW.removeRow(i);
        for(int i=0; i<xml.currency.size(); i++)
            if(i != 7)
                modelCurrency.addRow(new Object[]{xml.currency.get(i).tag, df.format(calc.caltulate(xml.currency.get(i), xml.currency.get(7), 1))});
        for(int i=0; i<xml.metal.size(); i++)
            modelMetal.addRow(new Object[]{xml.metal.get(i).name, df.format(calc.caltulate(xml.metal.get(i), xml.currency.get(7)))});
        for(int i=0; i<xml.GPW.size(); i++)
                modelGPW.addRow(new Object[]{xml.GPW.get(i).name, xml.GPW.get(i).current, xml.GPW.get(i).change});
    }//GEN-LAST:event_updateMouseClicked
    private void drawChart(Currency c)
    {
        ch = new Chart();
        ch.draw(c, xml.currency.get(7), days);
        chartPanel.add(ch.cp, BorderLayout.CENTER);
        chartPanel.validate();
    }
    private void currencyTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currencyTabMouseClicked
        c =  xml.currency.get(currencyTab.getSelectedRow());
        if(currencyTab.getSelectedRow() >= 7)
            c =  xml.currency.get(currencyTab.getSelectedRow()+1);
        drawChart(c);
    }//GEN-LAST:event_currencyTabMouseClicked

    private void radioButtom60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioButtom60MouseClicked
        
        days=xml.currency.get(0).rates.size()-1;
        drawChart(c);
    }//GEN-LAST:event_radioButtom60MouseClicked

    private void radioButtom30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioButtom30MouseClicked
        days=30;
        drawChart(c);
    }//GEN-LAST:event_radioButtom30MouseClicked

    private void radioButtom15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtom15ActionPerformed
        days=15;
        drawChart(c);
    }//GEN-LAST:event_radioButtom15ActionPerformed

    private void convertButtomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convertButtomMouseClicked
        try 
        {
            double q = Double.parseDouble(firstCurrency.getText());
            c1=xml.currency.get(firstCurrencyList.getSelectedIndex());
            c2=xml.currency.get(secondCurrencyList.getSelectedIndex());
            secondCurrency.setText(String.valueOf(df.format(calc.caltulate(c1, c2, q))));
        } 
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(jDialog1,"Niewłaściwy format.\n\nPrzykład właściwego formatu: 1.50");
        }    
    }//GEN-LAST:event_convertButtomMouseClicked

    private void clearButtomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtomMouseClicked
        firstCurrency.setText("");
        secondCurrency.setText("");
    }//GEN-LAST:event_clearButtomMouseClicked

    private void appInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appInfoMouseClicked
        JOptionPane.showMessageDialog(jDialog1,"Wersja: 1.0\n\nAutorzy: Łukasz Papierz, Szymon Serwin\n" + "\nWartości podawana są w polskich złotych\n"
                + "\nPochodzenie danych:\nKursy walut: Europejski Bank Centralny\n" + "Ceny kruszców: xmlcharts.com\n" + "Indeksy giełdowe: money.pl");
    }//GEN-LAST:event_appInfoMouseClicked

    private void firstCurrencyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstCurrencyKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
        {
            try 
            {
                double q = Double.parseDouble(firstCurrency.getText());
                c1=xml.currency.get(firstCurrencyList.getSelectedIndex());
                c2=xml.currency.get(secondCurrencyList.getSelectedIndex());
                secondCurrency.setText(String.valueOf(df.format(calc.caltulate(c1, c2, q))));
            } 
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(jDialog1,"Niewłaściwy format.\n\nPrzykład właściwego formatu: 1.50");
            }    
        }
    }//GEN-LAST:event_firstCurrencyKeyPressed
    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GPWTab;
    private javax.swing.JMenu appInfo;
    private javax.swing.JPanel calcPanel;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JButton clearButtom;
    private javax.swing.JButton convertButtom;
    private javax.swing.ButtonGroup currencyGroupRadioButtom;
    private javax.swing.JTable currencyTab;
    private javax.swing.JTable currencyTable;
    private javax.swing.JLabel dateTxt;
    private javax.swing.JTextField firstCurrency;
    private javax.swing.JComboBox firstCurrencyList;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private java.awt.Label label1;
    private javax.swing.JPanel listPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTable metalTab;
    private javax.swing.JRadioButton radioButtom15;
    private javax.swing.JRadioButton radioButtom30;
    private javax.swing.JRadioButton radioButtom60;
    private javax.swing.JTextField secondCurrency;
    private javax.swing.JComboBox secondCurrencyList;
    private javax.swing.ButtonGroup timeGroupRadioButtom;
    private javax.swing.JPanel timePanel;
    private javax.swing.JMenu update;
    // End of variables declaration//GEN-END:variables
    private XMLparser xml;
    private Chart ch;
    private int days;
    private Currency c;
    private Currency c1;
    private Currency c2;
    private Calculator calc;
    DecimalFormat df;
}