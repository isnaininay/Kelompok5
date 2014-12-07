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


    import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppKamus {
	// manggil class tree
	static BinaryTree tr = new BinaryTree();
	String line = "";
	// deklarasiin library array
	ArrayList<Node> ar = new ArrayList<Node>();

	public AppKamus() {
		Random r = new Random();
		Node data;
		String fileName = "kbbi.dict.csv";
		try {
			File f = new File(fileName);
			FileReader file = new FileReader(f);
			BufferedReader bc = new BufferedReader(file);
			// diulang sampai line tidak sama dengan null
			while ((line = bc.readLine()) != null) {
				//di split/pisah berdasarkan tab
				String tmp[] = line.split("\t");
				tmp[1] = tmp[1].replace("[pb]", "").replace("<br>", "");
				data = new Node();
				data.kata = tmp[0].trim().toLowerCase();
				data.makna = tmp[1];
				//semua baris yang telah dibaca masukkan ke array list
				ar.add(data);
			}
			bc.close();
		} catch (IOException e) {
			System.out.println("Error opening file !! ");
			System.exit(0);
		}
		// masukkan data yang ada di array ke dalam bentuk tree
		while (!ar.isEmpty()) {
			int rand = new Random().nextInt(ar.size());
			tr.insert(ar.remove(rand));
		}

	}

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		AppKamus Kamus = new AppKamus();
		System.out.println(" ===========================================");
		System.out.println(" KAMUS BESAR BAHASA INDONESIA (KBBI)");
		System.out.println(" ===========================================");
		String pilih = "y";
		while (pilih.equalsIgnoreCase("y")) {
			System.out.print(" masukkan kata yang ingin dicari : ");
			String key = sc.nextLine();
			System.out.println("---------------------------------------");
			tr.search(key);
			System.out.print("Find Again ? y/n : ");
			pilih = sc.nextLine();
		}

	}
}


