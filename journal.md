#Felicia's Journal

To document project progress, accomplishments, snags and time spent on this class.

[Time Log](TimeLog.md)

##Week 1
###1/24/16

Completed:
* Chose a project 
* Created the repository
* Worked on Project Plan
* Started thinking how I want the web pages to look 
* Began listing technologies and how they could fit in

###1/25/16

Completed:
* Added project plan
* Added journal
* Added timelog
* Modifed readme
* Researched http://usapl.liftingdatabase.com/. This website shows stats for nationally ranked USAPL powerlifters. 
* Researched http://www.goheavy.net/records/default.aspx. This website shows state powerlifting records. 

###1/26/16
I began researching dashboard design and creating a mockup for my landing page after a user logs in. 

##Week 2
###2/2/16
Continued researching dashboard design and creating a mockup for my landing page after a user logs in. Debating if I want to utilize bootstrap or start from scratch. 

###2/3/16
I worked on Week 2 exercises, which dealt with unit testing. I had not worked with unit testing before, and so I spent time researching unit testing because I wasn't sure how to get started. Completing the week 2 exercises took a lot longer than I anticipated. I am feeling overwhelmed with the amount of work that will be required for this class and the amount of time that I have to spend. 

In class, my VM was very unstable and froze/crashed on several occasions. Instead of trying to work with the VM, I am going to re-setup my environment on my laptop. 

##Week 3
###2/4/16
I spent a few hours re-setting up my environment. Most things seem to be working, except deploying a WAR using tomcat. I will need to troubleshoot this more soon. 

###2/7/16
Yesterday I spent the entire day working on a project for another class, so I wasn't able to work on anything for this class. Today, I worked on the exercises for Week 3 and began looking over a bootstrap theme. The bootstrap files contain so much information that I'm not sure where to start. It may be easier to start from scratch and only add-in what I need, rather than trying to delete what I don't need. 

##Week 4
###2/8/16
I found a free template for a dashboard that works off of bootstrap. The code is very well commented, which would make it easy to figure out how the code all works together. A blank template is also provided, so that the user can add in the content they want. Many examples are also provided. I've forked the GitHub repository, and will tenatively plan to use this in my project. 

###2/9/16
I'm not sure where the weeks have gone. I feel really overwhelmed trying to do so many things at once. This class is by far the most challenging/demanding class I've ever taken. At times I've felt like it just might be too much for me to take on with my 3 other classes, working fulltime, being a fulltime mom, and trying to somehow fit my training sessions for powerlifting in.

In just this class, I'm tryng to learn many new things (Intellij, Git, Github, unit testing, Hibernate, etc), keep up with the weekly exercises, find extracurricular/volunteer opportunities, and find time to work on my individual project. Tomorrow we already have a code review and I feel like I have barely started on my project. I've spent so much time working on the exercises and setting up my environment that I have had very little time to work on my project. 

Today, I took a first cut at my database design and created an ERD in visio. I then created the tables in my local database. I think that I may need to modify my tables slightly, but this should give me a good starting point. I also created my JSP pages. 

###2/14/16
Finally, I had some time to work on my project. I changed User in my database to Person, as this seemed to make more sense for my application. I still need to finish up work on the DAO, but I feel like I have a better understanding of how the DAO is working. I got many of my JSPs set up, and a lot of the HTML in the JSPs complete. I used bootstrap for my template, which was fairly easy to use and customize. I would definitely recommend bootstrap to others; this seems like a great resource. I was able to finish my database design, which I had been struggling with the past couple of weeks. I also set up my database within Intellij. I feel much better about where my project is at after code reviews last week, and the progress I was able to make today. 

##Week 5
###2/21/16
I spent time working on week 5 exercises, but wasn't able to get the login to work. I will continue working on this. 

##Week 6
###2/24/16
I worked on week 4 exercises over lunch at work today, and my laptop installed a windows update. This update moved many things on my laptop, which caused many issues with my project. With Paula's help, I was able to get everything back up and running, but this was pretty stressful. I was able to get the week 5 exercises working though, which is great. 

##Week 7
###3/6/16
This week I set up entities for all of my tables and began setting up DAOs. I also refactored my project structure so that a user must log in to access the website. I'm feeling pretty good about my project. I would like to be farther along, but I've had projects due for other classes and have not found the time. I'm hoping that I'll get some time over spring break. 

##Week 10
###3/29/16
Today I refactored my database, then set up entities and DAOs for all tables in my database. I also setup my remaining JSPs and began setting up controllers. I need to revisit projects from last semester Advanced Java to refresh my memory of servlets and controllers. I'm also a little fuzzy on how to use hibernate to select and insert data. I haven't had much time to work on this project lately because I've had many projects due for other classes, as well as midterms. Hoping to have more time in the coming weeks. 

###4/3/16
I worked on setting up one-to-many associations between my entities. I'm not clear on how to set up the associations, so this will require a lot more research. 

##Week 12
###4/16/16 - 4/18/16
I've been busy with the group project and have not had much time to work on my individual project. I finally found some time and continued to work on setting up associations between my entities. Working through the group project gave me a better understanding of how to set up the associations. Since I have more tables in this project, the setup process is taking a bit longer. I also have a many-to-many association that I need to research. 

I also worked on trying to display data on a page. Initially, I was just trying to dump data into a table to verify everything was set up correctly. The data wasn't displaying for some reason, so I reached out to Paula. After some more digging, I realized that the link was pointing directly to the JSP, and not the controller. Once I fixed the link, everything displayed correctly. 

##Week 13
###4/23/16 - 4/24/16
Getting down to the last few weeks! I'm panicking a bit because I feel like I should be farther along with my project. I worked on the forms and controllers, but I'm still trying to figure out how to make the forms work without adding too much complexity. 

##Week 14
###4/27/16 - 04/30/16
I took a couple of days off of work to work on this project. I spent a fair amount of time trying to add a chart to my dashboard. I got a chart to work, but then it starting displaying very oddly when I inserted more data through my forms. After some time, I gave up on the chart and scrapped it. I may work on this more next weekend, but I didn't want to spend too much time on something that is not crucial to the project. I finished setting up my forms. It took some time to work through how the forms should work so that the user does not have to enter the same information multiple times (a routine can occur on multiple weeks). I'm happy with how my forms ended up. I added a web service as well. I was torn on what to add for a web service, and ended up adding a re-captcha to my sign up page. This was fairly easy to implement. 

##Week 15
###5/3/16
I worked on adding javadoc and refactoring one of my controllers so that there isn't so much logic. I debated trying to work with a chart again, but gave up and decided to first work on feedback from the instructor review. 

###5/6/16
I added update and delete functionality - the user can now update or delete a routine. I've limited the update/delete functionality for now to a routine and routineExercise, but may add this functionality to other entities/tables in the future. I also worked on more JavaDoc and wrote some unit tests.

###5/8/16
I continued to work on JavaDoc and writing unit tests. I'm at about 50% code coverage, and think that may have to be where I end up. I'm not currently testing a majority of my controllers, since most are only displaying/inserting/updating using the daos. If there is logic in the controller, I did pull some logic out and am testing it. 
