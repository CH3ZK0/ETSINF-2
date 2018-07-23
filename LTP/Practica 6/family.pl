%%
%% declaraciones
%%
fatherof('juan', 'maria'). % juan es padre de maria
fatherof('pablo', 'juan'). % pablo es padre de juan
fatherof('pablo', 'marcela').
fatherof('carlos', 'debora').
fatherof('luisa', 'debora').
 
% A es hijo de B si B es padre de A
sonof(A,B) :- fatherof(B,A).
% A es abuelo de B si A es padre de C y C es padre B
grandfatherof(A,B) :- 
   fatherof(A,C), 
   fatherof(C,B).
% A y B son hermanos si el padre de A es tambi?n el padre de B y si A y B no son lo mismo
brotherof(A,B) :- 
   fatherof(C,A) , 
   fatherof(C,B), 
   A \== B.        
 
% A y B son familiares si A es padre de B o A es hijo de B o A es hermano de B
relativeof(A,B) :- 
   fatherof(A,B).
relativeof(A,B) :-
   sonof(A,B). 
relativeof(A,B) :- 
   brotherof(A,B).
relativeof(A,B) :- 
   grandfatherof(A,B).

