SELECT 
    ITEM_ID
    , ITEM_NAME
    , RARITY
FROM ITEM_INFO
WHERE ITEM_ID IN (SELECT T.ITEM_ID
                  FROM ITEM_INFO AS I
                        JOIN ITEM_TREE AS T
                        ON I.ITEM_ID = T.PARENT_ITEM_ID
                  WHERE RARITY = 'RARE')
ORDER BY ITEM_ID DESC