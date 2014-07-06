import java.awt.event.MouseMotionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
 
//import PlayArea.ButtonHandler;
 
 
public class PlayArea extends JPanel {
	private static final long serialVersionUID = 69L;
	private static final int POINTLESS = 0;
	private static final int POINTFUL = 2;
	
	protected int selectedShip = 0;
	protected int selectedShipSize = 0;
	private int mode = POINTLESS;
	//private Point curCursor;
	
	static Image target, hit, missed;
	private JLabel carrierH, battleshipH, destroyerH, submarineH, patrolboatH;
	private JLabel carrierV, battleshipV, destroyerV, submarineV, patrolboatV;
	static Ship shipsH[] = new Ship[6];
	static Ship shipsV[] = new Ship[6];
	
	private GridArea playerGrid, computerGrid;
	private JPanel fieldsP, shipsP, messageP;
	private JTextArea messageTA;
	
	public PlayArea() {
		JPanel mainPanel = new JPanel(new BorderLayout(20, 5));
		this.setLayout(new BorderLayout());
	
		
		target = (new ImageIcon(&quot;images/shoot.gif&quot;)).getImage();
		hit = (new ImageIcon(&quot;images/firex.gif&quot;)).getImage();
		missed = (new ImageIcon(&quot;images/splash.gif&quot;)).getImage();
 
		fieldsP = new JPanel();
		playerGrid = new PlayerGrid(this);
		computerGrid = new ComputerGrid(this);
		fieldsP.setLayout(new FlowLayout());
		fieldsP.add(playerGrid);
		fieldsP.add(computerGrid);
		//fieldsP.add(new LogoPanel());
		
		fieldsP.setBorder(new TitledBorder(&quot;BattleShip&quot;));
 
		messageTA = new JTextArea(&quot;BattleShip Game\n&quot;, 4, 0);
		(messageP = new JPanel()).setLayout(new BorderLayout());
		messageP.setBorder(new TitledBorder(&quot;Status: &quot;));
		messageP.add(new JScrollPane(messageTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
 
		mainPanel.add(fieldsP, BorderLayout.CENTER);
		mainPanel.add(messageP, BorderLayout.SOUTH);
 
		//ButtonHandler shipHandler = new ButtonHandler();
 
 
		shipsH[1] = new Ship(1, false);
		shipsH[2] = new Ship(2, false);
		shipsH[3] = new Ship(3, false);
		shipsH[4] = new Ship(4, false);
		shipsH[5] = new Ship(5, false);
		carrierH = new JLabel(new ImageIcon(shipsH[Ship.CARRIER].image));
		battleshipH = new JLabel(new ImageIcon(shipsH[Ship.BATTLESHIP].image));
		destroyerH = new JLabel(new ImageIcon(shipsH[Ship.DESTROYER].image));
		submarineH = new JLabel(new ImageIcon(shipsH[Ship.SUBMARINE].image));
		patrolboatH = new JLabel(new ImageIcon(shipsH[Ship.PATROLBOAT].image));
		
		MouseHandler dragger = new MouseHandler();
		carrierH.addMouseMotionListener(dragger);
		battleshipH.addMouseMotionListener(dragger);
		destroyerH.addMouseMotionListener(dragger);
		submarineH.addMouseMotionListener(dragger);
		patrolboatH.addMouseMotionListener(dragger);
		
		
		shipsV[1] = new Ship(1, true);
		shipsV[2] = new Ship(2, true);
		shipsV[3] = new Ship(3, true);
		shipsV[4] = new Ship(4, true);
		shipsV[5] = new Ship(5, true);
		carrierV = new JLabel(new ImageIcon(shipsV[Ship.CARRIER].image));
		battleshipV = new JLabel(new ImageIcon(shipsV[Ship.BATTLESHIP].image));
		destroyerV = new JLabel(new ImageIcon(shipsV[Ship.DESTROYER].image));
		submarineV = new JLabel(new ImageIcon(shipsV[Ship.SUBMARINE].image));
		patrolboatV = new JLabel(new ImageIcon(shipsV[Ship.PATROLBOAT].image));
		
		JPanel ships = new JPanel(new GridLayout(5,1));
		ships.add(carrierH);
		ships.add(battleshipH);
		ships.add(destroyerH);
		ships.add(submarineH);
		ships.add(patrolboatH);
	
		shipsP = new JPanel();
		shipsP.setLayout(new BorderLayout());
		shipsP.setBorder(new TitledBorder(&quot;Drag ship to place.&quot;));
		shipsP.add(ships, BorderLayout.CENTER);
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(shipsP, BorderLayout.WEST);
		//this.add(messageP, BorderLayout.SOUTH);
		this.setSize(1000,800);
		this.setVisible(true);
	}
	
 
	public Point getPoint()
	{
		Point cursor = null;
 
		mode = POINTFUL;
		do
		{
			cursor = computerGrid.getSelected();
			try
			{
				Thread.sleep(69);
			}
			catch(InterruptedException ie)	{ie.printStackTrace();}
		}
		while (cursor == null);
 
		mode = POINTLESS;
		return cursor;
	}
	
	public int ifPlayerHit(Point cursor) {
		int coordinate = playerGrid.getArea(cursor);
		if((coordinate)%10 == 0) {
			coordinate = coordinate + 100;
			playerGrid.setArea(cursor, coordinate);
			playerGrid.repaint();
		}
		else
			coordinate = -coordinate;
		
		return coordinate;
	}
	
	public int ifComputerHit(Point cursor) {
		int coordinate = computerGrid.getArea(cursor);
		if((coordinate/100)%10 == 0) {
			coordinate = coordinate + 100;
			computerGrid.setArea(cursor, coordinate);
			computerGrid.repaint();
		}
		else
			coordinate = -coordinate;
		
		return coordinate;
	}
	
	public void setResult(Point coordinates, int result)
	{
		int temp = computerGrid.getArea(coordinates);
		computerGrid.setArea(coordinates, result + temp);
		computerGrid.repaint();
	}
	/*
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((JButton)e.getSource()).setEnabled(false);
			if (e.getSource()== carrier) {
				
				//selectedShip = CARRIER;
				selectedShipSize = 5;
			}
			if (e.getSource()== battleship) {
				//selectedShip = BATTLESHIP;
				selectedShipSize = 4;
			}
			if (e.getSource()== destroyer) {
				//selectedShip = ;
				selectedShipSize = 3;
			}
			if (e.getSource()== submarine) {
				//selectedShip = SEAWOLF;
				selectedShipSize = 3;
			}
			if (e.getSource()==patrolboat) {
				//selectedShip = PATROL;
				selectedShipSize = 2;
			}
		}
	}
	*/
	public static void main(String args[]) {
		
		JFrame frame = new JFrame(&quot;BATTLESHIP&quot;);
		PlayArea sample = new PlayArea();
		frame.getContentPane().add(sample,BorderLayout.CENTER);
		frame.setVisible(true);
		frame.pack();
		Point curCursor;
		int result;
		
		while (true)
		{
			curCursor = sample.getPoint();
			result = sample.ifComputerHit(curCursor);		//In real game this is sent to &amp; recieved from opponent
			if (result&gt;0) 
				sample.setResult(curCursor, result);
			try	{	
				Thread.sleep(10);	
				}
			catch	(InterruptedException ie)	{	ie.printStackTrace();	}
		}
		
		
	}
	
	private class MouseHandler implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			if(e.getModifiers() == e.MOUSE_DRAGGED) {
				Point location = e.getLocationOnScreen();
			}
		}
		
		public void mouseMoved(MouseEvent e) {
			
		}
	}
}
 
 
class PlayerGrid extends GridArea
{
	public PlayerGrid(PlayArea handle)
	{
		super(&quot;Human&quot;, handle);
		ships[0] = new Ship(1, false);
		ships[1] = new Ship(2, true);
		ships[2] = new Ship(3, false);
		ships[3] = new Ship(4, true);
		ships[4] = new Ship(5, true);
		
		placeShip(ships[0], new Point(0,1));
		placeShip(ships[1], new Point(9,1));
		placeShip(ships[2], new Point(2,3));
		placeShip(ships[3], new Point(1,3));
		placeShip(ships[4], new Point(7,7));
		
	}
 
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		Ship temp;
		for(int i=0; i &lt; 5; i++) {
			temp = ships[i];
			g2.drawImage(temp.image, 25*(int)temp.getStart().getX(), 
					25*(int)temp.getStart().getY(), this);
		}
		
		
		int current;
		for (int y=0; y&lt;10; y++) for (int x=0; x&lt;10; x++)
		{
			if (area[x][y]!=0)
			{
				current = area[x][y]/10;
				
				if ((current/10)%10==1)
				{
					if (current%10!=0) g2.drawImage(PlayArea.hit, 25*x, 25*y, this);
					else g2.drawImage(PlayArea.missed, 25*x, 25*y, this);
				}
			}
		}
		if (mainHandle.selectedShipSize!=0 )
		{
			if (vertical) g2.fill3DRect(25*(int)cursorLocation.getX(),
				25*(int)cursorLocation.getY(), 25, 25*mainHandle.selectedShipSize, false);
			else g2.fill3DRect(25*(int)cursorLocation.getX(),
				25*(int)cursorLocation.getY(), 25*mainHandle.selectedShipSize, 25, false);
		}
		
		
	}
	
}
 
 
 
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
 
 
class GridArea extends JPanel
{
	protected int area [][] = new int[10][10];
	
	protected boolean vertical = false;
	private String title;
	private Point selected;
	protected Point cursorLocation;
	private Rectangle gridRects[][] = new Rectangle[10][10];
	protected PlayArea mainHandle;
	Ship[] ships = new Ship[5];
	
 
	public GridArea(String title, PlayArea mainHandle)
	{
		this.title = title;
		this.mainHandle = mainHandle;
		for (int y=0; y&lt;10; y++)
			for (int x=0; x&lt;10; x++) {
				gridRects[x][y] = new Rectangle(x*25,y*25,25,25);
				area[x][y] = 0;;
			}
 
		addMouseMotionListener(new MouseMovingHandler());
		addMouseListener(new MouseHandler());
 
		setOpaque(false);
	}
 
	
	public Point getSelected()
	{
		Point temp = selected;
		selected = null;
		mainHandle.selectedShip = 0;		//be sure to get the ship before getSelected
		return temp;
	}
 
	public Dimension getPreferredSize()		{	return new Dimension(251,270);	}
	public void setArea(Point where, int contents)
	{
		area[(int)where.getX()][(int)where.getY()] = contents;
	}
 
	public int getArea(Point check)
	{
		return area[(int)check.getX()][(int)check.getY()];
	}
 
	public void placeShip(Ship s, Point start) {
		int size = s.getSize();
		//int type = s.getType();
		vertical = s.getOrientation();
		s.setStart(start);
		if(isValid(s)) {
			if(vertical) 
				for(int i=0; i &lt; size; i++) 
					area[(int)start.getX()][(int)start.getY() + i] = 10;
				
			else
				for(int i=0; i &lt; size; i++) 
					area[(int)start.getX() + i][(int)start.getY()] = 10;
		}
	}
 
	protected boolean isValid(Ship s)
	{
		int size = s.getSize();
		vertical = s.getOrientation();
		Point start = s.getStart();
		
		if(vertical) 
			for(int i=0; i &lt; size; i++) {
				if(area[(int)start.getX()][(int)start.getY() + i] != 0)
					return false;
			}
		else
			for(int i=0; i &lt; size; i++) {
				if(area[(int)start.getX() + i][(int)start.getY()] != 0)
					return false;
			}
		return true;
	}
 
	public void paintComponent(Graphics g)
	{
		Graphics2D g2D = (Graphics2D)g; //convert to 2D for easier manipulations
		GradientPaint gp = new GradientPaint(0.0f, 0.0f,  
				new Color(40,100,140), 250.0f, 250.0f, new Color(40,180,210));
		
		g2D.setPaint(gp); //color of grid
		g2D.fillRect(0, 0, 250, 250);
		g2D.setColor(new Color(0,100,90));
		
		for (int i=1; i&lt;10; i++) { //grid lines
			g2D.drawLine(i*25, 0, i*25, 250); //vertical gridlines
			g2D.drawLine(0, i*25, 250, i*25); //horizontal gridlines
		}
		g2D.setColor(Color.black);
		g2D.draw3DRect(0,0,250,250,false);
 
		g2D.setColor(new Color(0,60,60));
		g2D.drawString(title, 125-(title.length()*4), 268);
		
		
	}
 
	private class MouseMovingHandler extends MouseMotionAdapter
	{
		private Rectangle lastSelected = new Rectangle();
 
		public void mouseMoved(MouseEvent e)
		{
			int x = (int)(e.getPoint().getX()/25);
			int y = (int)(e.getPoint().getY()/25);
 
			if(x&lt;10 &amp;&amp; y&lt;10 &amp;&amp; gridRects[x][y]!=lastSelected)
			{
				lastSelected = gridRects[x][y];
				cursorLocation = new Point(x,y);
				repaint();
			}
		}
	}
 
	private class MouseHandler extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			if(e.getModifiers() == e.BUTTON1_MASK)
			{
				selected = cursorLocation;
				//mainHandle.addMessage(&quot;You selected: &quot; + selected);	//delete this
			}
			if(e.getModifiers() == e.BUTTON3_MASK)
			{
				vertical = !vertical;		//toggles vertical ship placing state
				repaint();
			}
		}
	}
}
 
 
 
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
 
import javax.swing.ImageIcon;
 
class Ship implements MouseListener, MouseMotionListener{
	
	static final int CARRIER 	= 1;
	static final int BATTLESHIP = 2;
	static final int DESTROYER 	= 3;
	static final int SUBMARINE 	= 4;
	static final int PATROLBOAT = 5;
	
	Image image;
	private int type;
	private int size;
	private boolean vertical = false;
	private Point start;
	//public Point end;
	
	public Ship(int type, boolean orientation) {
		vertical = orientation;
		if(vertical) {
			switch(type) {
				case CARRIER: 
					image = (new ImageIcon(&quot;images/carrierV.gif&quot;)).getImage();
					size = 5;
					break;
				case BATTLESHIP:
					image = (new ImageIcon(&quot;images/battleshipV.gif&quot;)).getImage();
					size = 4;
					break;
				case DESTROYER: 
					image = (new ImageIcon(&quot;images/destroyerV.gif&quot;)).getImage();
					size = 4;
					break;
				case SUBMARINE: 
					image = (new ImageIcon(&quot;images/submarineV.gif&quot;)).getImage();
					size = 3;
					break;
				case PATROLBOAT: 
					image = (new ImageIcon(&quot;images/patrolboatV.gif&quot;)).getImage();
					size = 2;
					break;
			}
		}
		else {
			switch(type) {
				case CARRIER: 
					image = (new ImageIcon(&quot;images/carrierH.gif&quot;)).getImage();
					size = 5;
					break;
				case BATTLESHIP:
					image = (new ImageIcon(&quot;images/battleshipH.gif&quot;)).getImage();
					size = 4;
					break;
				case DESTROYER: 
					image = (new ImageIcon(&quot;images/destroyerH.gif&quot;)).getImage();
					size = 4;
					break;
				case SUBMARINE: 
					image = (new ImageIcon(&quot;images/submarineH.gif&quot;)).getImage();
					size = 3;
					break;
				case PATROLBOAT: 
					image = (new ImageIcon(&quot;images/patrolboatH.gif&quot;)).getImage();
					size = 2;
					break;
			}
		}
	}
	
	public Ship(Ship s) {
		image = s.image;
		size = s.getSize();
		vertical = s.getOrientation();
	}
	
	public int getType() {
		return type;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setStart(Point start) {
		this.start = start;
	}
	
	public Point getStart() {
		return start;
	}
	
	public boolean getOrientation() {
		return vertical;
	}
	
	public void setOrientation(boolean vertical) {
		this.vertical = vertical;
		if(vertical) 
			switch(type) {
				case CARRIER: 
					image = (new ImageIcon(&quot;images/carrierV.gif&quot;)).getImage();
					break;
				case BATTLESHIP:
					image = (new ImageIcon(&quot;images/battleshipV.gif&quot;)).getImage();
					break;
				case DESTROYER: 
					image = (new ImageIcon(&quot;images/destroyerV.gif&quot;)).getImage();
					break;
				case SUBMARINE: 
					image = (new ImageIcon(&quot;images/submarineV.gif&quot;)).getImage();
					break;
				case PATROLBOAT: 
					image = (new ImageIcon(&quot;images/patrolboatV.gif&quot;)).getImage();
					break;
			}
		else 
			switch(type) {
				case CARRIER: 
					image = (new ImageIcon(&quot;images/carrierH.gif&quot;)).getImage();
					break;
				case BATTLESHIP:
					image = (new ImageIcon(&quot;images/battleshipH.gif&quot;)).getImage();
					break;
				case DESTROYER: 
					image = (new ImageIcon(&quot;images/destroyerH.gif&quot;)).getImage();
					break;
				case SUBMARINE: 
					image = (new ImageIcon(&quot;images/submarineH.gif&quot;)).getImage();
					break;
				case PATROLBOAT: 
					image = (new ImageIcon(&quot;images/patrolboatH.gif&quot;)).getImage();
					break;
			}
	}
	
 
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.isMetaDown()) {
			if (vertical) {
				setOrientation(false);
				System.out.print(&quot;c&quot;);
			} 
			else {
				setOrientation(true);
				System.out.print(&quot;a&quot;);
			}
		}
	}
 
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
 
 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
 
 
class ComputerGrid extends GridArea
{	
	public ComputerGrid(PlayArea handle)
	{
		super(&quot;Computer&quot;, handle);
		ships[0] = new Ship(1, false);
		ships[1] = new Ship(2, true);
		ships[2] = new Ship(3, false);
		ships[3] = new Ship(4, true);
		ships[4] = new Ship(5, true);
		
		placeShip(ships[0], new Point(0,1));
		placeShip(ships[1], new Point(9,1));
		placeShip(ships[2], new Point(2,3));
		placeShip(ships[3], new Point(1,3));
		placeShip(ships[4], new Point(7,7));
		//placeShips();
		
	}
	
	private void placeShips() {
		boolean vertical;
		for(int i=0; i &lt; 5; i++) {
			if(Math.random()%2 == 0) 
				vertical = true; 
			else 
				vertical = false; 
				
			ships[i] = new Ship(i+1, vertical);
			do {
				placeShip(ships[i], new Point((int)Math.random()%10 ,(int)Math.random()%10));
			}while(!isValid(ships[i]));
			
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		Ship temp;
		
		for(int i=0; i &lt; 5; i++) {
			temp = ships[i];
			g2.drawImage(temp.image, 25*(int)temp.getStart().getX(), 
					25*(int)temp.getStart().getY(), this);
		}
		
		int current;
		for (int y=0; y&lt;10; y++) 
			for (int x=0; x&lt;10; x++)
			{
				if (area[x][y]!=0)
				{
					current = area[x][y]/10;
			
					if ((current/10)%10!=0)		//or could be written, ==1
					{
						if (current%10!=0) g2.drawImage(PlayArea.hit, 25*x, 25*y, this);
						else g2.drawImage(PlayArea.missed, 25*x, 25*y, this);
					}
				}
			}
	