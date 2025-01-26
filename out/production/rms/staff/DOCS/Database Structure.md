 **Hybrid Approach** <br> 
You can combine the above approaches by creating a `Person` table for shared fields and subclass-specific tables for additional fields. For example:

#### Table: `Person`
| id  | name      | age | type       |
|------|-----------|-----|------------|
| 1    | Alice     | 30  | Employee   |
| 2    | Bob       | 25  | Customer   |
| 3    | Charlie   | 40  | Employee   |

#### Table: `Employee`
| person_id | salary  | jobTitle    |
|-----------|---------|-------------|
| 1         | 50000   | Engineer    |
| 3         | 60000   | Manager     |

#### Table: `Customer`
| person_id | customerType | loyaltyPoints |
|-----------|--------------|----------------|
| 2         | Regular      | 200            |

#### Pros:
- Reduces data duplication by centralizing shared fields in the `Person` table.
- Subclass-specific data is stored in dedicated tables, minimizing `NULL` values.
- Flexible and scalable.

#### Cons:
- Slightly more complex queries (requires `JOINs`).

---
