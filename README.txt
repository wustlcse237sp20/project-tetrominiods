What user stories were completed this iteration?
	As of now, we have implemented the following stories:
		Keeping Scores
		Updated Title/Pause Screens/Buttons
		Have filled blocks
		Added Game instructions/controls
		Fixed the hold box a little more
		The queue is more functional
		We can now run from the master branch!
		
Is there anything that you implemented but doesn't currently work?
		We have a glitch where the game changes color for a second. We think it has to do with Sedgewick Draw and Eclipse not getting along at some point, but we tried to time the glitches so they happen around every 1000 points. We'll use this as a notification that you've reached the next 1000th point mark.
		The queue now updates with a new block, but not accurately (the block in the queue is not always the next block).
		The hold box is now larger to account for the longer blocks, but there is still some overflow if some blocks are placed into the hold box while in a rotated position.
		The pause button sometimes takes a couple clicks to work.
	
What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
	Hopefully we figured this out as well! List of commands:
	git checkout master
	cd src
	java finalProject.tetrisGame
	javac finalProject/tetrisGame.java
	java finalProject.tetrisGame
