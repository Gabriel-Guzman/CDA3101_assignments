.data

Str1: .asciiz "Enter the first integer x: "
Str2: .asciiz "Enter the second integer k: "
Str3: .asciiz "Enter the third integer n: "
Str4: .asciiz "The result of x^k mod n = "
newline: .asciiz "/n"

.globl main

.text
main:
    addi $a0, $zero, 0
    addi $a1, $zero, 0
    addi $a2, $zero, 0
    addi $a3, $zero, 0

    li $v0, 4 # Printing string 1
    la $a0, Str1 
    syscall

    li $v0, 5 # Reading arg x
    syscall

    addi $a1, $v0, 0

    li $v0, 4 # Printing string 2
    la $a0, Str2
    syscall

    li $v0, 5 # Reading arg k
    syscall

    addi $a2, $v0, 0

    li $v0, 4 # Printing string 3
    la $a0, Str3
    syscall

    li $v0, 5 # Reading arg n
    syscall

    addi $a3, $v0, 0

    jal fme
    addi $s0, $v0, 0

    li $v0, 4 # Printing string 4
    la $a0, Str4
    syscall

    li $v0, 1 # Printing result
    addi $a0, $s0, 0
    syscall

    li $v0, 5 # Printing string 4
    la $a0, newline
    syscall

    li $v0, 10 #exit
    syscall 

fme:
    addi $sp, $sp, -12 # Making room for 3 vars on stack frame
    sw $ra, 12($sp) # Storing ra on the top word

    addi $t1, $zero, 1
    sw $t1, 8($sp) # 8(sp) contains 'result'

    sw $a2, 4($sp) # 4(sp) contains 'k'

    lw $t1, 4($sp) # If k <= 0, branch to next
    blez $t1, next

    sra $a2, $a2, 1 # k = k / 2
    jal fme
    sw $v0, 0($sp)  # loading the result of the recursively called fme
                    # to temp

    addi $t1, $zero, 2 # Loading 2 to divide on next line
    lw $t2, 4($sp)
    div $t2, $t1

    mfhi $t2
    addi $t1, $zero, 1 # Loading 1 to compare on next line  
    bne $t2, $t1, notequal

    div $a1, $a3
    mfhi $t1
    sw $t1, 8($sp) # Moving result of x % n to result

notequal:
    lw $t1, 0($sp) # $t1 = temp
    mult $t1, $t1 # temp * temp
    mflo $t1 # CHECK THIS VALUE 

    lw $t2, 8($sp) # $t2 = result
    mult $t1, $t2

    mflo $t1 # $t1 = (result * temp * temp)

    div $t1, $a3
    mfhi $t1 # $t1 = (result * temp * temp) % n

    sw $t1, 8($sp) # result = $t1

next:
    lw $v0, 8($sp) # loading 'result' into $v0 for return 
    lw $ra, 12($sp) # loading original 'ra' into $ra
    addi $sp, $sp, 12 # clearing stack frame

    jr $ra
