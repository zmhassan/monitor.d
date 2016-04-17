## Paths
### createNotification
```
POST /api/alerts
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|inbox|inbox|true|NotificationDAO||


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

* */*

#### Tags

* notification-controller

### getAllInbox
```
GET /api/alerts
```

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

* */*

#### Tags

* notification-controller

### deleteNotification
```
DELETE /api/alerts/{id}
```

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

* */*

#### Tags

* notification-controller

### getNotificationById
```
GET /api/alerts/{id}
```

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

* */*

#### Tags

* notification-controller

### updateNotification
```
PUT /api/alerts/{id}
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|inbox|inbox|true|NotificationDAO||


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

* */*

#### Tags

* notification-controller

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

### getJobById
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

### getJobById
```
GET /api/jobs/{id}
```

#### Description

Query the database for job with the id provided in the url path

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

### getJobById
```
PUT /api/jobs/{id}
```

#### Description

Query the database for job with the id provided in the url

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

### createNode
```
POST /api/logs
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|node|node|true|LogDAO||


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

* */*

#### Tags

* log-controller

### getAllLogs
```
GET /api/logs
```

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

* */*

#### Tags

* log-controller

### deleteNode
```
DELETE /api/logs/{id}
```

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

* */*

#### Tags

* log-controller

### getLogById
```
GET /api/logs/{id}
```

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

* */*

#### Tags

* log-controller

### updateNode
```
PUT /api/logs/{id}
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|node|node|true|LogDAO||


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

* */*

#### Tags

* log-controller

### createNode
```
POST /api/nodes
```

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

### getAllNodes
```
GET /api/nodes
```

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

* */*

#### Tags

* node-controller

### deleteNode
```
DELETE /api/nodes/{id}
```

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

* */*

#### Tags

* node-controller

### getNodeById
```
GET /api/nodes/{id}
```

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

* */*

#### Tags

* node-controller

### updateNode
```
PUT /api/nodes/{id}
```

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

* */*

#### Tags

* node-controller

### getUser
```
POST /api/users
```

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

* */*

#### Tags

* user-controller

### getAllUsers
```
GET /api/users
```

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

* */*

#### Tags

* user-controller

### deleteUser
```
DELETE /api/users/{id}
```

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

* */*

#### Tags

* user-controller

### getOneUser
```
GET /api/users/{id}
```

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

* */*

#### Tags

* user-controller

### updateUser
```
PUT /api/users/{id}
```

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

* */*

#### Tags

* user-controller

