USE tracking;

-- GET: /api/customers/customer{customer_id}/shipments
SELECT c.customer_id, name, shipment_id, title
FROM customer c
         JOIN shipment s
              ON c.customer_id = s.customer_id
WHERE c.customer_id = 4;


-- GET: /api/customers/{customer_id}/shipments/{shipment_id}/statuses
SELECT c.customer_id, name, s.shipment_id, title, type, create_date
FROM customer c
         JOIN shipment s
              ON c.customer_id = s.customer_id
         JOIN status st
              ON s.shipment_id = st.shipment_id
WHERE c.customer_id = 4
  AND s.shipment_id = 2;
