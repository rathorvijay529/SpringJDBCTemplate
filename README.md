# SpringJDBCTemplate 

This is project is all about to learn spring concepts only.we are using JDBCTemplate and Hibernate


## Installation Eclipse 

•	Go to New, select import and choose git
•	Select clone URI (copy the URL from the repository)
•	Right-click on ur project and Select configure.
•	Select convert to maven
•	maven install

## Server problem(unable to include project into Apache Tomcat)(optional)
```bash
•	select Windows-->show views-->others-->Navigators
•	Go to project ,open .settings file
•	open *facet.core.xml
•	<installed facet="jst.web" version="3.1"/>  to <installed facet="jst.web" version="2.5"/>

 ```




## Process to be followed for creating Git repo
```bash
•    create a repository in GitHub by signing up
•    git init
•    touch .gitignore(to ignore particular folder in repo)
•    git add . (local adding all files use . also)
•    git remote add origin <repoURL>  (Remote adding all files use . also)
•    git commit (committing all the files)
•    git push origin master (pushing master branch)
•    git branch -a (checking all available branch,* will show current branch)
•    git  branch -b develop (creating develop branch)
•    git push origin develop (pushing develop branch.

 ```
## Committing the changes to develop using git bash:

```bash
•    Go to the project directory and right click and open git bash.
•    use the following commands to commit and push the code.
•    git status
•    git add  <files path which will show in red lines, add one by one>
•    git commit
•    git push origin develop
•    Go to GitHub and check whether changes have pushed to repo or not.
•    Raise the pull request in git hub to push the changes in master. 
(There should not be any conflicts)(PR will review by approver and then merged if all ok)

 ```
 
 ## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
