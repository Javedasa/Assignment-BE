# Assignment-BE

Approve Consultant API:

Explanation: This API should allow administrators to view all consultant requests and approve or reject them.
Functionality:
Endpoint: /consultant-requests
Method: GET
Description: Retrieves all consultant requests from the database.
Endpoint: /consultant-requests/{requestId}/approve
Method: PUT
Description: Approves the consultant request with the specified ID.
Endpoint: /consultant-requests/{requestId}/reject
Method: PUT
Description: Rejects the consultant request with the specified ID.
Add Additional Details in Consultant Account API:

Explanation: This API should allow adding additional details to a consultant's account, including name, age, phone number, and CV.
Functionality:
Endpoint: /consultants
Method: POST
Description: Adds details to the consultant table for a particular consultant.
Request Body: JSON object containing consultant details (name, age, phone number, CV).
Consultant Details API:

Explanation: This API should provide endpoints to retrieve the list of all consultants and get details of a specific consultant by name or job role.
Functionality:
Endpoint: /consultants
Method: GET
Description: Retrieves the list of all consultants.
Endpoint: /consultants/{name}
Method: GET
Description: Retrieves details of the consultant with the specified name.
Endpoint: /consultants/job-role/{jobRole}
Method: GET
Description: Retrieves details of consultants with the specified job role.
