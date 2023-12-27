# Birthday Wisher
A simple spring boot project to wisher people happy birthday 
## How it works
Get your ```apikey``` by sending your email to this end point ```localhost:6097/birthdaywisher/wisher/youremail``` apikey would be sent to your email. Now passing the ```apikey``` in your request header call this end point ```localhost:6097/birthdaywisher/schedule/add``` pass this  
```
private Long wisherId;
private String birthdayPersonName;
private String wisherName;
private String email;
private String birthdayMessage;
private Date birthday;
``` 
as request body every day at midnight application would  wish everybody happy-birth day
## Installation
Clone project navigate to ```BirthdayWisherApplication``` class click run make sure u have MySql DB installed and database with name ```birthday_wisher``` created 