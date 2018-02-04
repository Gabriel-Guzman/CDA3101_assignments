.data
A: .word -89, 19, 91, -23, -31, -96, 3, 67, 17, 13, -43, -74

Str1: .asciiz "Average of positive array elements: "

.globl main

.text
main:
	addi $t1, $zero, 0 #sum
	addi $s0, $zero, 0 #average

	addi $t2, $zero, 0 #i
    addi $s1, $zero, 12 #array size

    la $a0 A
    addi $t3, $zero, 0 #temp variable for array
    addi $t4, $zero, 0 #counter for average
loop:
    beq $t2, $s1, exit #exit loop if i == 12
    lw $t3, 0($a0) #load next address
    bltz $t3, endif #if current array element < 0, branch to endif
    add $t1, $t1, $t3 #sum+=array [i]
    addi $t4, $t4, 1

endif:

    addi $t2, $t2, 1 #i++
    addi $a0, $a0, 4 #increment the address by 4
    j loop
exit:
    div $t1, $t4 #calculate average
    mflo $s0 #move result to $s0 register

    li $v0, 4
    la $a0, Str1
    syscall #print Str1

    li $v0, 1
    add $a0, $s0, 0
    syscall #print average

	li $v0, 10 # Sets $v0 to "10" to select exit syscall
	syscall # Exit
