select o.product_name
from orders o
         join customers c on o.customer_id = c.id
where c.name = :name;