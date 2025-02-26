# 🌳 Maximum Depth of Binary Tree - Wyszukiwanie najgłębszego powiązania w drzewie binarnym.

## 🔹 Jak działa Binary Tree MaxDepth na przykładzie Javy?

Java **nie „wie” sama z siebie**, że to drzewo.  
To **my mówimy jej**, jak przechodzić po nim dzięki **rekurencji**.

---

## 📌 **Jak działa `maxDepth`?**
Każdy węzeł **sprawdza maksymalną głębokość swojego lewego i prawego poddrzewa**, a następnie dodaje `+1`, bo liczy też siebie.

💡 **FILO - Stos (First In, Last Out)** → Rekurencja działa jak **stos wywołań funkcji**, czyli najpierw wchodzimy w głąb, a potem się cofamy.

---

## 🔄 **Krok po kroku, jak Java liczy głębokość?**


Przykładowe drzewo:  

![obraz](https://github.com/user-attachments/assets/90a6657e-1ad7-4ef6-ba79-75f1b8bfd87a)


  
### **1️⃣ Wywołujemy `maxDepth(3)`**
- **Oblicza `maxDepth(9)`**
- **Oblicza `maxDepth(20)`**

---

### **2️⃣ Wywołujemy `maxDepth(9)`**
- `maxDepth(null) = 0` (brak lewego dziecka)
- `maxDepth(null) = 0` (brak prawego dziecka)
- **Wynik:** `1 + max(0,0) = 1`

---

### **3️⃣ Wywołujemy `maxDepth(20)`**
- **Oblicza `maxDepth(15)`**
- **Oblicza `maxDepth(7)`**

---

### **4️⃣ Wywołujemy `maxDepth(15)`**
- `maxDepth(null) = 0`
- `maxDepth(null) = 0`
- **Wynik:** `1 + max(0,0) = 1`

---

### **5️⃣ Wywołujemy `maxDepth(7)`**
- `maxDepth(null) = 0`
- `maxDepth(null) = 0`
- **Wynik:** `1 + max(0,0) = 1`

---

### **6️⃣ Wracamy do `20`**
- **Wynik:** `1 + max(1,1) = 2`

---

### **7️⃣ Wracamy do `3` (root)**
- **Wynik:** `1 + max(1,2) = 3 ✅`

➡️ **Java „zlicza” poziomy drzewa, cofając się w rekurencji!** 🔥  

---

## 🛠 **Implementacja w Javie w pliku example.java**
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;  // Jeśli drzewo jest puste, zwracamy 0
        int leftDepth = maxDepth(root.left);  // Głębokość lewego poddrzewa
        int rightDepth = maxDepth(root.right); // Głębokość prawego poddrzewa
        return Math.max(leftDepth, rightDepth) + 1;  // Bierzemy większą i dodajemy bieżący węzeł
    }
}
