/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kamus;

/**
 *
 * @author Isnaini Hayati
 */
public class BinaryTree {

	Node root;

	boolean isEmpty() {
		return root == null;
	}

	void insert(Node tmp) {
		if (isEmpty()) {
			root = tmp;
		} else {
			Node current = root;
			Node parent = null;
			boolean diKiri = true;
			while (current != null) {
				parent = current;
				if (current.kata.compareTo(tmp.kata) < 0) {
					current = current.kanan;
					diKiri = false;
				} else {
					current = current.kiri;
					diKiri = true;
				}
			}
			if (diKiri) {
				parent.kiri = tmp;
			} else {
				parent.kanan = tmp;
			}
		}
	}

	void traverse(Node d, String prefix) {
		if (d != null) {
			if (d.kata.startsWith(prefix)) {
				System.out.println(" - " + d.kata + "\t\t\t" + d.makna);
				this.traverse(d.kanan, prefix);
			}
			this.traverse(d.kiri, prefix);
		}
	}

	void search(String cari) {
		cari = cari.toLowerCase().trim();
		Node current = root;
		while (current != null) {
			if (current.kata.startsWith(cari)) {
				this.traverse(current, cari);
				break;
			} else {
				if (current.kata.compareTo(cari) < 0) {
					current = current.kanan;
				} else {
					current = current.kiri;
				}
			}
		}
	}
}

    

