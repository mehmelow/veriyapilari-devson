/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minheap;

/**
 *
 * @author ozge
 */
import java.util.Scanner;
// ağaca sağ sol tanımı
class Node
{
    int data;
    Node left, right;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    
    private static int size(Node root)
    {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
 
    
    private static boolean isHeap(Node root, int i, int n)
    {
        // base case
        if (root == null) {
            return true;
        }
 
        
        if (i >= n) {
            return false;
        }
 
        
        if ((root.left != null && root.left.data <= root.data) ||
                    (root.right != null && root.right.data <= root.data)) {
            return false;
        }
 

        return isHeap(root.left, 2*i + 1, n) &&
            isHeap(root.right, 2*i + 2, n);
    }
 
    
    public static boolean isHeap(Node root)
    {
        int i = 0;
        return isHeap(root, i, size(root));
    }
 
    public static void main(String[] args)
    {
        
        
        int i, s = 0;
        int dizi[] = new int[10];

        Scanner sc = new Scanner(System.in);
 
        System.out.print("10 tane sayı girin :");
 
        for (i = 0; i < dizi.length; i++) {
            dizi[i] = sc.nextInt();
        }
 
        // burda diziye geçirip ağaca dönüştürdüm
        for (int sayi:dizi) {
            System.out.print(sayi+" ");
        }
        int a1 = dizi[0];
        int a2 = dizi[1];
        int a3 = dizi[2];
        int a4 = dizi[3];
        int a5 = dizi[4];
        int a6 = dizi[5];
        int a7 = dizi[6];
                
        Node root = new Node(a1);
        root.left = new Node(a2);
        root.right = new Node(a3);
        root.left.left = new Node(a4);
        root.left.right = new Node(a5);
        root.right.left = new Node(a6);
        root.right.right = new Node(a7);
 
        if (isHeap(root)) {
            System.out.print(" uygundur ");
        }
        else {
            System.out.print(" değildir ");
        }
    }
}

