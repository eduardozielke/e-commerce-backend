CREATE OR REPLACE FUNCTION public.create_cart_after_user_insert()
    RETURNS trigger
AS
$$
begin
    INSERT INTO carts (user_id, created_at, updated_at) VALUES (NEW.id, NEW.created_at, NEW.updated_at);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER create_cart
    AFTER INSERT
    ON users
    FOR EACH ROW
EXECUTE PROCEDURE public.create_cart_after_user_insert()