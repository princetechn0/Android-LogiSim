# LogiSim: An Android Logic Simulator

## Our Vision: To Create an intuitive introduction to Logic Circuits

## Team Name: Due Date Fighters

### Members: Ali Ataya, Tyler Moua, Anthony Tisdale, Ian Hill, Kai Kit Lok

### Featues to implement: Undo/Redo, Feedback, More Logic Gate Configurations(NAND and XOR)
	
### Introduction:

	The following is a design document for the UI of an android logic simulator. 
	This logic simulator features NOT, AND, and OR logic gates as well as programmable input switches and output LEDs. 
	Gates will be added and subtracted at the user’s discretion. 
	The program also features wiring inputs to outputs. 
	The goal of this application is to give these students an intuitive platform to test their knowledge of Boolean logic with circuit elementary tools. 
	Customer/Users:
		This app is developed for computer science students who have some exposure to Boolean logic.
		This means that they should have some understanding of the Boolean operations AND, OR, and NOT as well as how they function in Boolean algebra.

	This app provides an intuitive platform for students to test their knowledge of Boolean logic. 
	Students will create a basis of understanding for representing Boolean logic with logic circuits. 
### How Do Logic Circuits Work? 
	
	Logic circuits are circuits that utilize logic gates in order to process inputs and output outputs. Each logic gate processes specified inputs and gives an output based on the nature of that gate. An AND gate has two inputs and one output. This gate outputs a 1 when both inputs are 1 and outputs a 0 in all other cases. An OR gate has two inputs and one output. This gate outputs a 0 when both inputs are 0 and outputs a 1 in all other cases. A NOT gate has one input and one output. This gate outputs the opposite of its input. That is, an input of 1 will have an output of 0 and vice versa. Logic circuits are wired in a way such that the output of one gate is used as input of another. The output of one gate can be used as the input to as many other gates as needed.

### Visuals: 
	The screen is segregated into two sections: 
		A workspace and the button menu. 
		The workspace is a 30x15 grid and takes up 80 percent of the screen. 
	The remaining screen is reserved for the button menu. 
	Each circuit element will only take up about 2% of the workspace (Give or take), with a maximum of 10 circuit elements. 
		This means that a circuit with 10 circuit elements would take up 20% of the workspace. 
		The remaining area of the workspace is preserved for wires and readability. 
	The workspace is composed of a graph backdrop and circuit elements of the circuit whose positions are confined to the graph. 
	A circuit element takes up a 3x3 square in the grid. 
	Wire connections are also displayed in the workspace. 
	The input and output nodes of each circuit element exist as cells in a circuit element. 
	The output nodes are on the rightmost center node of an element. (If an element exists from (0, 0) to (2, 2), its output node will at (2, 1). 
	The input node varies based on which element is being used. 
	Wires are drawn as straight lines from one node to another. 
	Another notable feature is the color of empty elements, the switches and LEDs. 
	There are 10 preset colors for a maximum of 10 circuit elements. 
	Stipulations:
		Elements cannot overlap in the workspace. 
		Buttons are highlighted blue when selected and the Play/Save buttons become red when active. 
		While the circuit is playing, and LED is yellow when high and grey when low.

	Toast Messages:
		Temporary, on-screen messages to provide simple feedback.
		
### Elements of the UI Circuit elements:
	Input Switches:
		These switches can be set to output a 1 or 0
	Gates:
		AND
		OR
		NOT
		NAND
		XOR
	Output LED:
		The LED will be “on” when its input is 1. Else, it will be “off” 
	Buttons:
		Run Button
		Subtract Button
		Wire button
		Element Type Adder Buttons:
			AND button
			OR button
			NOT button
			XOR button
			NAND button
			Switch button
			LED button
			1/0 Button
		Intro Button
		Save Button
		State Buttons:
			A Button
			B Button
			C Button
		UNDO Button
		REDO Button
		CLEAR Button
		RANDOM Button

### How the User Interacts With the Interface:
	The UI of this app will allow users to select circuit elements in the workspace and use buttons in order to modify these circuit elements. 
	
	Element Selecting/Deselecting and User States: 
		In total there are 3 states a user can toggle: 
			Circuit element selection 
			Button selection 
			Menu selection 
		To select a circuit element, simply tap on the circuit element. 
		Each button is only usable based on the state that the user is in. 
	
		The following states the user can be in and their associated buttons:
			No circuit element selected:
				Run button
				Add button
				Save button
				A, B, and C buttons (Load)
				UNDO button
				REDO button
			Element selected:
				Sub button
				Wire button
				If the selected circuit element is empty:
					Element type modifier buttons
				If the selected circuit element is a switch:
					1/0 button
			Button selected:
				If the Save Button is selected:
					A, B, and C buttons (Save)

		Selecting/Deselecting:
		To select any circuit element, tap on it while no other elements or buttons have been selected
		To deselect any circuit element or button Tap on the same circuit element.
		To deselect any button, tap on the grid.
		Moving a Circuit Element: 
			To move a circuit element, simply select the circuit element and tap on the grid at your desired location.
	
	Using Buttons: 
		To use a button, ensure that you are in the correct state and simply tap on the desired button.
		Run Button:
			Make sure the all nodes have been connected.
			This button runs the circuit and toggles play mode.
			While in play mode, the toggle button can be used but no other buttons.
		Add Element Button:
			Make sure there are less than 10 elements and the top left region of the screen is not occupied by an existing circuit element.
			This button adds a circuit element to the top left region of the workspace.
		Subtract Element Button:
			Make sure you have selected an element.
			This button removes a selected circuit element.
			Removing a circuit element will also remove all of its associated wire connections.
		Wire Button: o Make sure you have selected an element.
			This button allows the user to wire a connection from an input node to an output node.
			The output node of the previously element will serve as the start of the wire.
			Once the button has been selected, the user may select the input node of another gate to wire to.
			Restrictions:
				A gate cannot be wired to itself.
				The first element must have an output node.
				The second element must have an input node.
		Element Type Adder Buttons:
			Make sure you have selected an empty element
			AND Button:
				This button changes the selected empty circuit element to an AND gate.
			OR Button:
				This button changes the selected empty circuit element to an OR gate.
			NOT Button:
				This button changes the selected empty circuit element to a NOT gate.
			XOR button:
				This button changes the selected empty circuit element to an XOR gate.
			NAND button:
				This button changes the selected empty circuit element to a NAND gate.
			SWITCH Button:
				This button changes the selected empty circuit element to an input.
			LED Button:
				This button changes the selected empty circuit element to an LED.
			1/0 Button:
				This button changes the input of a switch to 1 or 0.
		Save Button:
			This button allows the user to save their schematic.
			Once this button has been selected, the user must select the A, B, or C button in order to save the current schematic to that button.
		A, B, and C Buttons:
			These buttons allow the user to save or load a schematic to or from a given button.
			If the save button has already been selected, this button saves the current schematic.
			If the save button has not been selected, this button will load a saved schematic.
			If there is no saved schematic, an empty schematic will be loaded.
		UNDO Button:
			This button allows the user to undo the last change they made to the circuit.
		REDO Button:
			This button allows the user to redo the last undo command.
### The Code Class Hierarchy:
	LogicSimulator
	TouchProcessor
	GridAndMenu 
	Node
		ElementOrButton
			CircuitElement
				SWITCH
				LED
				GATE
					NOTGATE
					TwoInOneOut 
						ANDGATE
						ORGATE
						XORGATE
						NANDGATE
						
			
	Schematic 
				
### LogicSimulator Class:
	This class handles the creation of the application. It has four major methods:

	onCreate: Handles getting the resolution, setting objects and the contentView, as well as updating the screen initially. 
	
	setObjects: Handles the initialization of the objects needed to run the game. 
	
	getResolution: Handles getting the display size and setting that to a Point.
 
	onTouchEvent: Handles getting the user touch as a motionEvent and sends that input into the TouchProcessor object. 

### TouchProcessor Class: 
	This class handles the motionEvent from the LogicSimulator class and, based on the position of the motionEvent, sends a touchpoint to the GridAndMenu Class. It communicates with the GridAndMenu class to check for elements, buttons, or if we are wiring in order to determine what the user has selected. The user will have selected a button, Circuit element, or node. Based on which, the touchProcessor creates a touchpoint from that motionEvent with a specified cellSize. This touchpoint is sent to a specific method of the GridAndMenu object. 

### GridAndMenu Class: This class is the largest and handles the bulk of the application.
	Fields: There are five fields that determine the state that we are in: 
		Point selectedElement: this is the location of the element we have selected 
		Point selectedButton: This is the location of the button we have selected 
		Point selectedNode: This is the location of the Node we have selected If any of these points are null, we know that we are not in the state. 
		Boolean fields playing and saving: both tell the system if we are playing the circuit or saving a schematic. 
	
		This class also has a Context field which is sent to each gate in order to enable the creation of their own bitmap images.
		This class also has several arrays that it uses to track objects: 
			CircuitElement [][]savedShematics: 
				This is a 3d array that holds the saved schematics 
			Button[] menu: 
				This array holds each button. 
				The x position of each button is the same value as its index in this array. 
				This class uses this relationship to refer to the buttons. 
			Node[][] cells: 
				This array holds each cell of the visual grid on the screen. 
				It is used to print this grid. 
			CircuitElement[] elements: 
				This array holds the Circuit Elements in the current schematic. 
				Circuit Elements are held in an array because this class will often check each element for something. (ie checking each element to see if one is an LED, then calling lightUp if the LED is high) 
		This class also has an int value for each cell size: small(node), large(CircuitElement), and menu(Button). 

		There are also various fields for the numbers of things (ex. Horizontal cells, Active elements, savable schematics...) used for creating arrays, cell sizes, or printing. 
	
		Printing Methods: 
			There are various methods that print to the canvas. 
			updateScreen is the main printing method this is called my LogicSimulator. It calls each individual printing/drawing method in a specific order. Of the other various
			
### Schematic Class
	This class handles the array of circuit elements that represents our schematic.
	Fields:
		int numberOfCircuitElements

		CircuitElement[] circuit:
			This field is the container for the circuit elements in a given schematic.
	Methods:
		toString:
			This method returns a string containing the labels of each element, seperated by commas.
			It is used for tracking the contents of the undo/redo stack
			
### Printing and Drawing Methods
	There are three notable printing and drawing methods: 
		updatePlay: 
			This method checks for an LED and if we’re playing and .eval returns true, then the LED will light up. 
		printWires: 
			This method checks all the elements and, if the element has a connection(if element.a != null) , then it will drawWires to draw a wire from that elements output node to the connections input node. There is a conditional to tell if it is the top of bottom node being wired to. This information is send to the drawWires method as well as the type of element. 
		drawWires: 
			This method takes in a start point, end point, int value to tell which node is being wired, and a string for the type of element being wired. This information is used for the canvas to determine where an input node is on the screen.

### Menu Selection Handling
		play: 
			Checks for any null connections in the circuit then toggles playing in both this class and the PLAY class. 
		add: 
			Checks to make sure that: Top left region of the screen is not occupied (That is where an added gate spawns) We have not reached the maximum number of gates allowed Then the first null element in the elements array is instantiated as a CircuitElement. 
		sub: 
			This method first checks that selectedElement != null. Then, it calls removeConnections and sets the element that we have selected to null in our elements array. removeConnections: This method removes an elements wire connections. It checks each element in the elements array and if element.a or element.b (The inputs of those elements) is the element that we are removing, they are set to null. 
		wire: 
			This method first checks that we have selected an element and the element has an output node (Check that we have selected a valid element). After this, selectedNode is set to the postion of the selected elements output node. We are now in wiring mode. 
		and, or, not, inputSwitch, led: 
			These elements all first check that the selected element is a CircuitElement object, then replaces that object with an new instance of their own class(ie. and replaces a CircuitElement with an ANDGATE), passing in the position of the initial CircuitElement object into the constructor of that new gate. 
		Save: 
			This method toggles the saving Boolean in both this class as well as in the Save object in our menu array.

		saveOrLoad: 
			This method is called by the A, B, and C buttons. Based on the saving Boolean value, it will call the saveSchematic or loadSchematic method. Based on the button (A,B or C) the method will send an int to the method call. 
		saveSchematic: 
			This method replaces the CircuitElements array of the savedSchematics 3d array, indexed at an input from the saveOrLoad method, with the elements array. 
		loadSchematic: 
			This method replaces the elements array with either an empty array (if there is no saved schematic at the index) or the saved schematic at the index sent from the saveOrLoad method. 
		Workspace Selection Methods: 
			elementSelect: 
				This method is called by the touchProcessor in order to set the selectedElement Point to the location of an element at the users touch. When an element is selected, the selectedButton is nulled. 
			gridSelect: 
				This method handles moving an element and deselecting a button. It is called by the touchProcessor when the user selects an empty grid cell. 
			wireTwoElements: 
				This method is called by the touchProcessor when the selectedNode is not null, meaning that we are in wiring mode. It calls the setConnection method in order to connect two circuit elements. After wiring, the selectedNode, selectedElement, and selectedButton Points are set to null. 
			Other Methods: 
				The following methods aid in various tasks and validations: 
					getElement: 
						This method checks all the Circuit Elements’ positions in the elements array to check if it matches a given position. If it does, the index of that element is returned, else -1 is returned. 
					setConnection: 
						This method associates one element with another. That is, it sets the .a value of an element to another element on the circuit. 
					getClosestNode: 
						This method returns the closest input node from the users touch. move: This method changes the position of an element. 
					nullConnections: 
						This method returns a Boolean value: true if there are any null connections in the entire schematic(Meaning that it checks the .a and .b values of all the elements in the elements array for null), and false if there aren’t any.
					onScreenToast:
						This method creates a toast object to be used for displaying useful feedback.
					deleteAll:
						This method creates a new Schematic instance and resets the screen.
					randomCircuitGenerator:
						This method randomly displays (3) preset layouts.
						
						
						
### Undo and Redo Methods
	The Undo method is called upon user interaction. It first pushes its top element onto the Redo stack. Then, it sets the elements variable to the value popped from the Undo stack. 
	
	The Redo method serves a similar purpose. It first pushes its top element onto the Undo stack. Then, it sets the elements variable to the value popped from the Redo stack.

### Classes 

	Node Class:
		This class represents any element that is positioned as a grid point. It has a Point for holding a position.
	
	ElementOrButton Abstract Class (extends Node): 
		This class introduces the fields that both circuit elements and buttons use: int textSize, int blockSize, and String label. They are for printing and coloring an element or button. 
		
	CircuitElement Class (extends ElementOrButton): 
		This class introduces the fields that a circuit element will need. Each circuit element has input and output nodes as well as associated circuit elements (Association through wiring). Because of this, the class introduces the fields: CircuitElement a, Node outputNode; and ArrayList inputNodes (Depending on the type of circuit element, it may have 1, 2 or no input nodes). This class introduces methods for drawing circuit elements, the major methods being idle and select. Idle draws the circuit element normally. Select will color an element blue to indicate that it has been selected by the user. This class also introduces the logic based methods of each gate: SetA, Eval, and checkPosition. (The Switch class does not need SetA . I have not refactored this yet) (Each Circuit element that extends this class has its own update method which updates the positions of its input and output nodes as the elements position changes.) 
		
	SWITCH Class (extends CircuitElement):
		This class introduces the field Boolean state, which refers to the state of an input switch. It has the methods toggle, which changes the state as well as its label (1 or 0), and eval, which returns the state. 
		
	LED Class (extends CircuitElement): 
		This class has the method lightUp, which colors itself yellow. This method is only called when eval returns true. (It may be more effective to override the idle method from the Circuit Element class and have the button colored yellow when eval return true.) 

	GATE Class (extends CircuitElement): 
		This class introduces two bitmaps (for drawing the gates) temp and icon. It also introduces an override for the draw method, which draws the icon on the canvas. 
		
	NOTGATE Class (extends GATE): 
		This class has the method setBitmap, which loads an unedited bitmap image into Temp. Icon is a resized version of temp. Its eval function returns the opposite of its inputs eval function. 
		
	TwoInOneOut Abstract Class (extends GATE): 
		This class introduces the methods and fields that both AND and OR gates use. It has a second associated circuit element, CircuitElement b. It also has the methods setB and update. And gates and OR gates share an update method because the positions of the input and output nodes on the two gate are the same. 
		
	AND Class (extends TwoInOneOut): 
		This class has its own setBitmap method unique to its bitmap image. Its eval function returns true when a and b return true, else false. 
		
	OR Class (extends TwoInOneOut): 
		This class has its own setBitmap method unique to its bitmap image. Its eval function returns true when a or b return true, else false. 
		
	XOR Class (extends TwoInOneOut): 
		This class has its own setBitmap method unique to its bitmap image. Its eval function returns false when a and b return true or both a and b return false. 
		
	NAND Class (extends TwoInOneOut): 
		This class has its own setBitmap method unique to its bitmap image. Its eval function returns false when a or b return true, else false. 	
		
	Button Abstract Class (extends ElementOrButton): 
		This class introduces the methods for printing buttons: printLabel, printButtons, select, and color. SUB, AND, OR, NOT, WIRE, SWITCHBUTTON, LEDBUTTON, TOGGLE, INTRO, CLEAR, RANDOM, and A, B, and C Classes (All extend Button or NoColor). These classes have unique labels that are given to the object in the constructor.


	Glossary 
		AND Gate:
			An AND gate has two inputs and one output. This gate outputs a 1 when both inputs are 1 and outputs a 0 in all other cases.
	
		OR Gate: 
			An OR gate has two inputs and one output. This gate outputs a 0 when both inputs are 0 and outputs a 1 in all other cases.
			
		NOT Gate: 
			A NOT gate has one input and one output. This gate outputs the opposite of its input. That is, an input of 1 will have an output of 0 and vice versa. 
		
		NAND Gate:
			A NAND gate has two inputs and one output. This gate outputs a 0 when both inputs are 1 and outputs a 1 otherwise.
			
		XOR Gate: 
			An XOR gate has two inputs and one output. This gate outputs a 0 when both inputs are 0 or 1 and outputs a 1 in all other cases.
			
		
			
		Wire: 
			A Wire serves as a visual connection between an output node of one gate to the input nodes of others. 
			
		Switch:
			A switch is a settable circuit element that is used as a preliminary input. The switch has no input.
			
		LED: 
			An LED is a circuit element that has no output. It has a state “on” or “off” that depends on its input.

		Toast: 
			A toast provides simple feedback about an operation in a small popup. It only fills the amount of space required for the message and the current activity remains visible and interactive. Toasts automatically disappear after a timeout. 
