fp_applet is an applet designed for the mapping of for floor plan regions to inventory assignments.

The mapping of the applet pages are as follows:

MENU.java
---------
Region Search	-->	FP_Main.java 		-->	MapPanel.java	--> InventoryPanel.java
Lookup Query	-->	LocalSearch.java
Set Directory 	-->	DebugPanel.java

Functionality--

	Region Search: 
		1) Opens a new window asking for file name. Format for filename should be name
		2) Opens an interactive panel with the floor panel displayed. The image should be stored
	   	   in the img folder as (name).png
		3) Clicking on a region bound in the area specified in (name).yaml in the config folder
	       will open a new inventory panel showing the content in its own panel.

	Lookup Query:
		1) Opens up a panel. As of now only local search is implemented
		2) Searching for an entity will open up a new panel 
		3) Panel will contain what region file it came in as well as corresponding location
	
	Set Directory:
		1) Sets the working directory. Should do this first if directory is not specified.
		2) Clicking will open up a new panel. Type in the working directory and hit ok.
	


Configurations --	
	configs are currently stored as 
	region.yaml:	x1,x2,y1,y2,r1
	regionInfo.csv: c1,r1