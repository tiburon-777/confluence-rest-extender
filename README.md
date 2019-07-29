[![OCTOPUS CodeWare](https://www.tiburon.su/files/logo_octo_text_600_153.png)](https://www.tiburon.su)

REST API Extender for Confluence
================

REST API for automated Confluence configuration with URMS


Resources
---------

All resources produce JSON (media type:  `application/json`) results.

### Page versions

Get and delete outdated page versions

* #### `GET /rest/extender/1/api/versions/all`

  **QueryString**
  - type: all or page or attachment. (default:all)
  - endDays: 1～ (0=today, 1=yesterday) (default:0)
  - limit: 1～1000 (default:1000)

  Get all page versions in all instance.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.

* #### `DELETE /rest/extender/1/api/versions/all`

  **QueryString**
  - type: all or page or attachment. (default:all)
  - endDays: 1～ (0=today, 1=yesterday) (default:0)
  - limit: 1～1000 (default:1000)

  Remove all page versions in all instance.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.


* #### `GET /rest/extender/1/api/versions/space/{spaceKey}`

  **QueryString**
  - spaceKey: Key of the target space. (required)
  - type: all or page or attachment. (default:all)
  - endDays: 1～ (0=today, 1=yesterday) (default:0)
  - limit: 1～1000 (default:1000)

  Get all page versions in space with key=`spaceKey`.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.

* #### `DELETE /rest/extender/1/api/versions/space/{spaceKey}`

  **QueryString**
  - spaceKey: Key of the target space. (required)
  - type: all or page or attachment. (default:all)
  - endDays: 1～ (0=today, 1=yesterday) (default:0)
  - limit: 1～1000 (default:1000)

  Remove all page versions in space with key=`spaceKey`.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.


* #### `GET /rest/extender/1/api/versions/page/{pageId}`

  **QueryString**
  - pageId: Id of the target page. (required)
  - type: all or page or attachment. (default:all)
  - endDays: 1～ (0=today, 1=yesterday) (default:0)
  - limit: 1～1000 (default:1000)

  Get versions of the page with id=`pageId`.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.

* #### `DELETE /rest/extender/1/api/versions/page/{pageId}`

  **QueryString**
  - pageId: Id of the target page. (required)
  - type: all or page or attachment. (default:all)
  - endDays: 1～ (0=today, 1=yesterday) (default:0)
  - limit: 1～1000 (default:1000)

  Remove versions of the page with id=`pageId`.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.

### Trashes

Get and delete trash

* #### `GET /rest/extender/1/api/trash/all`

  **QueryString**
  - limit: 1～1000 (default:1000)

  Get all trash in all instance.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.

* #### `DELETE /rest/extender/1/api/trash/all`

  **QueryString**
  - limit: 1～1000 (default:1000)

  Remove all trash in all instance.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.


* #### `GET /rest/extender/1/api/trash/space/{spaceKey}`

  **QueryString**
  - spaceKey: Key of the target space. (required)
  - limit: 1～1000 (default:1000)

  Get trash from space with key=`spaceKey`.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.

* #### `DELETE /rest/extender/1/api/trash/space/{spaceKey}`

  **QueryString**
  - spaceKey: Key of the target space. (required)
  - limit: 1～1000 (default:1000)

  Remove trash from space with key=`spaceKey`.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.




  **QueryString**
  - type: all or page or attachment. (default:all)
  - endDays: 1～ (0=today, 1=yesterday) (default:0)
  - limit: 1～1000 (default:1000)

  Remove versions of the page with id=`pageId`.

  __Responses__

  ![Status 200][status-200]

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.

  









### Syncronise Crowd User Directory

* #### `GET /rest/extender/1/directory`

  Get info about User Directories.

  __Responses__

  ![Status 200][status-200]

  ```javascript
  [
    {
      "id": 262145,
      "type": "INTERNAL",
      "issynchronising": false
    },
    {
      "id": 1277953,
      "type": "CROWD",
      "issynchronising": false
    }
  ]
  ```

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.

* #### `PUT /rest/extender/1/directory`


  **QueryString**
  - id: User Directory ID. (required)

  Start sycronyse User Directory.

  __Responses__

  ![Status 200][status-200]

  If OK, `issynchronising` of target directory returned as `true`

  ```javascript
  [
    {
      "id": 262145,
      "type": "INTERNAL",
      "issynchronising": false
    },
    {
      "id": 1277953,
      "type": "CROWD",
      "issynchronising": true
    }
  ]
  ```

  ![Status 401][status-401]

  Returned if the current user is not authenticated.

  ![Status 403][status-403]

  Returned if the current user is not an administrator.


[status-200]: https://img.shields.io/badge/status-200-brightgreen.svg
[status-400]: https://img.shields.io/badge/status-400-red.svg
[status-401]: https://img.shields.io/badge/status-401-red.svg
[status-403]: https://img.shields.io/badge/status-403-red.svg
[status-404]: https://img.shields.io/badge/status-404-red.svg
