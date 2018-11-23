# FA18OOPDA_GROUP6_RealEstate

Team #6 

Members:  Alex Buck
          Rich Erskine
          Emily Fliegel
          Denisha Pimentel
Project Name:
          Acme Realty

Project Scenario:
          All customers will be asked whether they are buying or sellingproperty. Depending on their answer...Buyer: Selects what they want the property to contain (accessories, commercial/residential, size, type of house, etc.). Then the agency will show them a list of available properties based on these parameters. Then they buy/rent a property, and the bought/rented propertyis archived on an “archived properties” list.Seller:Puts up a propertyand lists its contents. The contents being the parameters buyers can use to search for properties. An appraiser looks at thepropertyand puts a price on it based on what the property contains. Finally, the house is put up in the database of “to sell” houses.
          
11/23/18 - Hi everyone, I finished the Realtor class and modified the first frame (CreateGUI class) because it was only displaying the button "selling". I included an excel file of sample properties; I modified a class (FileReader) from a previous lab to read data in the meantime but I'm working on a separate class that reads and writes excel files to see how it could work best. If you have questions or suggestions, let me know. Also, Rich, I tried to fix the problem in the Appraiser class, with your approach (using an inner class) the compiler stops before finishing reading the event handler, I made it a method and called it using the same lambda and got several exceptions thrown. I'll keep looking into it. - Denisha
          
11/20/18 - Hey guys, I added my Appraiser class to the master and I uploaded my attempt of sellerGUI to a pull. It needs help in that, I can't make the button work to add all the stuff together and print it to a file. I'm not sure where I went wrong with it, but if someone could take a peak that would be great.
-Rich
          
11/15/18 - Hey guys, I remade Property class to basically be all encompasing. It has a default, empty constructor and a constructor that accepts all our variables. It would eliminate the need for all the other crazy subclasses, but keep rentable as an inherent. This should cut down on on confusion and class bloat. 

I also edited the Appraiser class in Denisha's pull as what I thought the class should look like.
- Rich

10/27/18 - Divided the GUI into three frames, an opening frame that asks if a user is buying or selling, a frame for buyers and a frame for sellers. It's stored in branch guiTake2 -Emily 

10/22/18 - I uploaded the Realtor and Appraiser classes along with some ideas to develop the more complicated methods -Denisha

10/22/18 - I uploaded a sort of "skeleton" for the GUI in a branch "guiTake1". Contact me if you have any questions or ideas - Emily

10/22/18 - I uploaded the .java version of the Propery classes and added the cover page to our readme file. - Rich

10/17/18 - Hey guys, I uploaded the Property class and subclasses I was working on. They need work, but they should 
give us a starting point. I wanted their toStrings to be basic for file output reasons and maybe make it easier to
read the variables with less fluff. I only wrote default constructors, and will add more once we get a feel for how we 
want to populate each class. - Rich
