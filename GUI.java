package scripts;

import javax.swing.JFrame;

public class GUI extends JFrame {

	private javax.swing.ButtonGroup actionGroup;
	private javax.swing.JRadioButton bank;
	private javax.swing.JRadioButton drop;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JRadioButton oak;
	private javax.swing.JButton start;
	private javax.swing.JRadioButton tree;
	private javax.swing.ButtonGroup treeGroup;
	private javax.swing.JRadioButton willow;
	private javax.swing.JRadioButton yew;
	boolean regTree = false;
	boolean tOak = false;
	boolean tWillow = false;
	boolean tYew = false;
	boolean mBank = false;
	boolean mDrop = false;


	public GUI() {
		initComponents();
	}

	public void initComponents() {
		treeGroup = new javax.swing.ButtonGroup();
		actionGroup = new javax.swing.ButtonGroup();
		tree = new javax.swing.JRadioButton();
		oak = new javax.swing.JRadioButton();
		willow = new javax.swing.JRadioButton();
		yew = new javax.swing.JRadioButton();
		start = new javax.swing.JButton();
		drop = new javax.swing.JRadioButton();
		bank = new javax.swing.JRadioButton();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		treeGroup.add(tree);
        tree.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tree.setText("Tree");

        treeGroup.add(oak);
        oak.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        oak.setText("Oak Tree");

        treeGroup.add(willow);
        willow.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        willow.setText("Willow Tree");

        treeGroup.add(yew);
        yew.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        yew.setText("Yew Tree");

        start.setText("Start Script");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        actionGroup.add(drop);
        drop.setText("Drop logs");

        actionGroup.add(bank);
        bank.setText("Bank logs");

		jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		jLabel1.setText("Choose your tree and What you would like to do with the logs:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup().addComponent(tree).addGap(18, 18, 18)
										.addComponent(oak).addGap(18, 18, 18).addComponent(willow).addGap(18, 18, 18)
										.addComponent(yew))
								.addGroup(layout.createSequentialGroup().addGap(31, 31, 31)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(drop).addComponent(bank))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 198,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(0, 0, Short.MAX_VALUE)).addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(tree)
						.addComponent(oak).addComponent(willow).addComponent(yew))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup().addComponent(drop)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(bank))
						.addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(13, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
	}

	private void startActionPerformed(java.awt.event.ActionEvent evt) {
		if (tree.isSelected()) {
			regTree = true;
		}
		if (oak.isSelected()) {
			tOak = true;
		}
		if (willow.isSelected()) {
			tWillow = true;
		}
		if (yew.isSelected()) {
			tYew = true;
		}
		if (bank.isSelected()) {
			mBank = true;
		}
		if (drop.isSelected()) {
			mDrop = true;
		}
		this.dispose();
	}
	public String getTree() {
		if(regTree) {
			return tree.getText();
		}
		if(tOak) {
			return oak.getText();
		}
		if(tWillow) {
			return willow.getText();
		}
		if(tYew) {
			return yew.getText();
		}
		return null;
	}
	public String getMethod() {
		if (mBank) {
			return "bank";
		}
		if(mDrop) {
			return "drop";
		}

		return null;

	}

}
