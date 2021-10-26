select c.id, c.name, c.surname, o.product_name, o.amount, o.date
from orders o
         left join customers c on c.id = o.customer_id
where upper(name) = upper(?);