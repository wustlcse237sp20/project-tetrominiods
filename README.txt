What user stories were completed this iteration?
	As of now, we have implemented the following stories:
<<<<<<< HEAD
		Moving Blocks over Time
		Rotating Blocks (mostly)
		Ensuring Blocks stay within Boundaries
		Minor UI Coloring
		End Screen
		Collision Checks
		'Speed Up' Function by pressing Down
		
What user stories do you intend to complete next iteration?
		'Preview' Block that shows where piece will go
		Fast Dropping
		Full Rotation for applicable Pieces
		Animated Background
		'Queue' of pieces that will appear
		'Hold' function
		Potentially a pause screen
	
Is there anything that you implemented but doesn't currently work?
	Clearing Lines once completed. The code has since been removed as it caused runtime errors on run. We plan on getting this working as the first part of our Iteration 2.
	
What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
	Unfortunately, as of writing this, we could not get it to compile through command line, but works perfectly fine if imported through IntelliJ or Eclipse.
=======
		Ability to "Hold" pieces
		Replace "Hold" Pieces on button input
		Remove cleared lines
		Add Pause Screen
		Add Start/Menu Screen
		Added setColor() methods to objects
		Added upcoming pieces to a Queue
		Fixed 4way rotation issues
		
What user stories do you intend to complete next iteration?
		Keeping Scores
		Animated Background for title screen
		Add game instructions to the board
		Have filled blocks
		Refactoring code, try to split large classes into different objects
		Clean up any kinks in the game
		Maybe add music?
	
Is there anything that you implemented but doesn't currently work?
	There's currently an issue where sometimes if a line is cleared it throws an error. We're not exactly sure what the problem is but we hope to have that fixed during Iteration 3. There's also an issue with the queue where the next piece doesn't properly iterate through the nextPieces, to prevent it disrupting the UI it now remains static throughout the game. This will also be fixed in iteration 3.
	
What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
	Unfortunately, as of writing this, we could not get it to compile through command line, but works perfectly fine if imported through IntelliJ or Eclipse.
>>>>>>> ce0d70072d78214bd4bef10bc8c9bf109243c276
