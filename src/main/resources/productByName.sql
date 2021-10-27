select c.name, o.product_name, o.amount
from orders o
         left join customers c on c.id = o.customer_id
where upper(name) = upper(?);