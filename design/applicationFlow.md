# Application Flow

### User Sign up

1. User chooses sign up on the menu (available on all pages, unless the user 
is signed in already).
2. User fills out the sign up form and submits.
3. Request goes to sign up servlet.
4. Servlet creates a user object and then creates user in the database.
5. Response to user confirming addition (show a message on the jsp)

### User Sign In

1. User chooses sign in on the menu (available on all pages, unless the user 
is signed in already).
2. User enters username and password on form and submits. 
3. If user is authenticated, the server will handle allowing access to edit 
pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
4. If authentication fails, show error message/page.

### Dashboard/Landing page
1. Option only available to logged in users
2. User views summary data
  2.1 current program
  2.2 upcoming training session (table),
  2.3 sessions remaining for week
  2.4 chart of recent progress (charts.js)
  2.5 current PRs
  2.6 goals (e.g. your goal is: [x], only [x] lbs until you reach your goal!, you've reached your goal)

### Add Program
1. Option only available to logged in users
2. User enters program details
  2.1. enter name for program
  2.2. enter program begin date
  2.3. enter program end dt
  2.4. enter program notes
  2.5. enter number of training sessions per week
  2.6  enter deload week frequency (e.g. every 3 weeks)
  2.7  enter check-in frequency (e.g. every 3 weeks)

### Add Training Session 
1. Option only available to logged in users
2. User enters training session details
  2.1. enter a name for the session
  2.2. select exercises in training session (or add new if does not already exist)
    2.2.1. if new, enters exercise name, exercise type, notes
  2.3  select recurrence pattern (none, weekly, biweekly)
  3.4. select range of recurrence (start, end after [x] ocurrences)
  3.5. enter weight, reps, sets for each occurence (if 4 occurences, enter data for 4 occurences)
3. Details are sent to Add TrainingSession servlet
4. Servlet creates TrainingSession object
5. Servlet sends object to dao
6. Dao adds TrainingSession to the database
7. Servlet sends confirmation to page that TrainingSession has been added.

### Add Training Session Details (individual session)
1. Option only available to logged in users
2. User enters training session details
  2.1. enters completed date (if applicable)
  2.2. enters weight, reps, sets performed/completed
  2.3. enters notes
  3.5. enter weight, reps, sets for each occurence (if 4 occurences, enter data for 4 occurences)
3. Details are sent to Add TrainingSessionDetails servlet
4. Servlet creates TrainingSessionDetails object
5. Servlet sends object to dao
6. Dao adds TrainingSessionDetails to the database
7. Servlet sends confirmation to page that TrainingSessionDetails has been added.

### Add Goal
1. Option only available to logged in users
2. User enters goal details
  2.1. select exercise
  2.2. select target date
  2.3. select goal weight
3. Details are sent to Add Goal servlet
4. Servlet creates Goal object
5. Servlet sends object to dao
6. Dao adds Goal data to the database
7. Servlet sends confirmation to page that Goal has been added.

### View Training Session(s)

1. User selects from entered programs, weeks, sessions 
2. Page sends a request to view training sessions servlet along with criteria 
3. Servlet uses the trainingsessions dao to select training sessions according to criteria
1. Dao performs select and creates training session objects from results.
1. Dao returns list of training sessions matching criteria to servlet.
1. Servlet sends list back to training sessions jsp.
1. Training sessions jsp displays the session(s) in a table format (specific session, sessions for week, sessions for program)

### View PRs

1. Page sends a request to view PR servlet
2. Servlet uses the PR dao to select PRs
3. Dao performs select and creates PR objects from results.
4. Dao returns list of PRs to servlet.
5. Servlet sends list back to PR jsp.
6. PR jsp displays the PRs in a chart.

### View Progress
1. Page sends a request to view Progress servlet
2. Servlet uses the Progress dao to select Progress data
3. Dao performs select and creates Progress objects from results.
4. Dao returns list of Progress data to servlet.
5. Servlet sends list back to Progress jsp.
6. Progress jsp displays the Progress data in a chart.
