## Paths
### getAllJobs
```
GET /api/jobs
```

#### Description

Provides list of jobs that monitord has executed or is pending execution

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|JobDAO array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* job-controller

### createJob
```
POST /api/jobs
```

#### Description

Inserts a new job into the database

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|job|job|true|JobDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|201|Created|JobDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* job-controller

### deleteJobById
```
DELETE /api/jobs/{id}
```

#### Description

Delete job from database with the id provided in the url

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|JobDAO|
|204|No Content|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* job-controller

### updateJobById
```
PUT /api/jobs/{id}
```

#### Description

Update job entry with the id provided in the url

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|job|job|true|JobDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|JobDAO|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* job-controller

### getJobById
```
GET /api/jobs/{id}
```

#### Description

Query the database for job entry with the id provided in the url path

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|JobDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* job-controller

### getAllLogs
```
GET /api/logs
```

#### Description

Provides list of Logs that monitord has executed or is pending execution

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|LogDAO array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* log-controller

### createLog
```
POST /api/logs
```

#### Description

Creates of log entry that monitord has captured

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|log|log|true|LogDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|201|Created|LogDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* log-controller

### deleteLogById
```
DELETE /api/logs/{id}
```

#### Description

Delete log from database with the id provided in the url

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|LogDAO|
|204|No Content|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* log-controller

### updateLog
```
PUT /api/logs/{id}
```

#### Description

Update of log entry that monitord has captured

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|log|log|true|LogDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|LogDAO|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* log-controller

### getLogsById
```
GET /api/logs/{id}
```

#### Description

Query the database for log entry with the id provided in the url path

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|LogDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* log-controller

### getAllNodes
```
GET /api/nodes
```

#### Description

Provides list of nodes that monitord is managing

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|NodeDAO array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* node-controller

### createNode
```
POST /api/nodes
```

#### Description

Inserts a new Node entry in the database

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|node|node|true|NodeDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|201|Created|NodeDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json

#### Tags

* node-controller

### deleteNodeById
```
DELETE /api/nodes/{id}
```

#### Description

Delete node from database with the id provided in the url

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|NodeDAO|
|204|No Content|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* node-controller

### updateNodeById
```
PUT /api/nodes/{id}
```

#### Description

Update node entry with the id provided in the url

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|node|node|true|NodeDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|NodeDAO|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* node-controller

### getNodeById
```
GET /api/nodes/{id}
```

#### Description

Query the database for job entry with the id provided in the url path

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|NodeDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* node-controller

### getAllNotifications
```
GET /api/notification
```

#### Description

Provides list of notifications that monitord is managing

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|NotificationDAO array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* notification-controller

### createNotification
```
POST /api/notification
```

#### Description

Inserts a new notification entry in the database

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|notification|notification|true|NotificationDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|201|Created|NotificationDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* notification-controller

### deleteNotificationById
```
DELETE /api/notification/{id}
```

#### Description

Delete notification from database with the id provided in the url

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|NotificationDAO|
|204|No Content|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* notification-controller

### updateNotificationById
```
PUT /api/notification/{id}
```

#### Description

Update notification entry with the id provided in the url

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|notification|notification|true|NotificationDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|NotificationDAO|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* notification-controller

### getNotificationById
```
GET /api/notification/{id}
```

#### Description

Query the database for notification entry with the id provided in the url path

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|NotificationDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* notification-controller

### getAllUsers
```
GET /api/users
```

#### Description

Provides list of notifications that monitord is managing

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|UserDAO array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* user-controller

### createUser
```
POST /api/users
```

#### Description

Inserts a new user entry in the database

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|user|user|true|UserDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|201|Created|UserDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* user-controller

### deleteUserById
```
DELETE /api/users/{id}
```

#### Description

Delete user from database with the id provided in the url

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|UserDAO|
|204|No Content|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* user-controller

### updateUserById
```
PUT /api/users/{id}
```

#### Description

Update user entry with the id provided in the url

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|user|user|true|UserDAO||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|UserDAO|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* user-controller

### getUserById
```
GET /api/users/{id}
```

#### Description

Query the database for user entry with the id provided in the url path

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|UserDAO|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* user-controller

