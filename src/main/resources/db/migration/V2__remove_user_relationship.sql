ALTER TABLE expenses
DROP CONSTRAINT IF EXISTS expenses_user_id_fkey,
DROP COLUMN IF EXISTS user_id;