# common data types and useful method

## integer, no max or min value
a = 1

## integer to string
s = str(a)
print("type of s:",type(s))

## integer (ASCII or Unicode) to char
c = chr(99)
print("c:", c)

## float
f = 0.99

# ================================ #
print("================================")

## string
s = " worlD"

## strings are mutable, string concatenation
print("Hello" + ", world!")

## length of string
print(len(""))

## useful methods
print(s.upper())
print(s.lower())
print(s.replace("o","0"))
print(s.strip())
print(s.split("r"))

## find occurance in string
print("Found:", s.find("wo"), ",Not found:", s.find("hype"))
print("D" in s)

## check string
s1 = "x749yv66"
print(s1, "is alphabetic", s1.isalpha())
print(s1, "is alphanumeric", s1.isalnum())
print("114.514 is decimal number:", "114.514".isdecimal())
print("114514 is number:", "114514".isdigit())

## slices
s = "Avral city"
print(s[5:])
print(s[2:3]) # 3 is not include, only one character will be printed
print(s[-5:-1]) # -1 is last character

# ================================ #
print("================================")

## boolean
b = True
b1 = False

## most values are True
print(bool(1))
print(bool("xd"))

## except
print(bool(None))
print(bool(0)) # only 0 in the integer type is false
print(bool(""))

# ================================ #
print("================================")

## list
list = []

## can hold different types
list.append(1)
list.append("")

print(list)

## access & update element
list[0] += 1
print(list[0])

list[0:2] = [3, "x"]
print(list)

## insert at specific index
list.insert(len(list), True)
print(list)

## remove element
list.remove("x") # remove first occurance
list.pop(len(list)-1) # remove element at given index
print(list)
list.clear() # clear the entire list

## loop through list
for e in list:
    print(e)

for i in range(len(list)):
    print(list[i])

[print(e) for e in list] # short hand loop

## comprehension
foods = ["apple", "banana", "citrus", "dragon fruit"]

# newlist = [expression for item in iterable if condition == True]
picked = [x for x in foods if x != "citrus"]
print(picked)

## sort
a_list = [100, 45, 98, 27, 32]
a_list.sort() # ascending, alphanumerically
print(a_list)

## sort descending
## a_list.sort(reverse=True)

## custom sorting
## need a function that returns a number for an element in list
## the smaller the number the forwarder the element will be
def my_func(n) -> int:
    '''
    sort list based on how close the number is to 50

    n: element in list
    '''
    return abs(n-50)

a_list.sort(key=my_func)
print(a_list)

## list are passed by reference
another_list = a_list # they points to same object in heap
another_new_list = another_list.copy() # copies list instead of passing reference
# another_new_list = list(another_list) # or do this

## join list
a_list = a_list + another_new_list

print(a_list)
