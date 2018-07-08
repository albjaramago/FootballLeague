# FootballLeague
League Table

Football League Table has has been done through the implementation of an interface which provides different methods to work with data from Matchs.

The instantiation of the FootballLeague has been done singleton and synchronized to be thread safe.

List of Matchs are processed to create a Map of LeagueTableEntry in which key is the TeamName. 
From each Match two items are put in the Map. One for the HomeTeam and the other for the AwayTeam.

The Map has been implemented as an HashMap to have unique keys. The HashMap also provides the control of Nodes through the hashcode and this makes
easier the updating of already existing items in the HashMap.

Sorting of LeagueTableEntry List has been done with the stream().sort lambda function of Java 8.

Unitary tests assert that the complete list of LeagueTableEntry List is generated and they also provide assertion for calculation of points, goals, win, lost and draw 
aswell as sorting on points, goal difference, goals for and team names.
