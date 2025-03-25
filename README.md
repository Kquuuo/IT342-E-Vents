# Google Calendar API Integration for Events Booking

## List Events

**Endpoint Name:** Get available events  
**HTTP Method:** `GET`  
**URL:** `http://localhost:8080/api/events`  

### Description
Retrieves a list of available events for users to view and book.

### Request Headers
- `Authorization: Bearer <access_token>` (Optional, if required)

### Response Example (Success - `200 OK`)
```json
{
  "events": [
    {
      "id": 1,
      "name": "Concert Night",
      "date": "2025-03-28",
      "location": "Gymnasium",
      "price": 20.00
    },
    {
      "id": 2,
      "name": "Job Expo",
      "date": "2025-03-27",
      "location": "LRAC",
      "price": 0.00
    }
  ]
}
```

### Error Responses
| Status Code | Meaning |
|------------|---------|
| `500 Internal Server Error` | Server issue while fetching events |

---

## Book Event (Google Calendar Integration)

**Endpoint Name:** Book an event and add to Google Calendar  
**HTTP Method:** `POST`  
**URL:** `http://localhost:8080/api/events/{eventId}/book`  

### Description
Allows a user to book an event, which will then be added to their Google Calendar.

### Request Headers
- `Authorization: Bearer <access_token>` (Required)
- `Content-Type: application/json`

### Request Parameters
| Parameter   | Type   | Description |
|------------|--------|-------------|
| `eventId` | `integer` | The ID of the event being booked |

### Request Body (JSON)
```json
{
  "userEmail": "user@example.com"
}
```

### Response Example (Success - `200 OK`)
```json
{
  "status": "success",
  "message": "Event added to Google Calendar",
  "calendarEventLink": "https://calendar.google.com/event?eid=abcd1234"
}
```

### Error Responses
| Status Code | Meaning |
|------------|---------|
| `400 Bad Request` | Missing or invalid input data |
| `401 Unauthorized` | Authentication failed |
| `404 Not Found` | Event not found |
| `500 Internal Server Error` | Failed to communicate with Google Calendar API |

