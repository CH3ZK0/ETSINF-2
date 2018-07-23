module Signum where

-- Definicio de la funcio signum' (signe):
signum' x = if x < 0 then -1 else
			if x == 0 then 0 else 1
