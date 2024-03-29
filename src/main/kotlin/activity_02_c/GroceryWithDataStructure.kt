package activity_02_c

fun main(){
    var groceryItemList = ArrayList<String>()
    var itemName: String? = null
    var isPerishable: Boolean = false
    var itemOnSaleTotal: Int = 0
    var ItemSoldTotal: Int = 0

    var itemCount: Int = 0
    var itemCategory: String = ""
    var itemColor: String = ""
    var itemSKU: Long = 0
    var groceryInventoryList = ArrayList<String>()
    var groceryItemCharacteristic = ArrayList<String>()
    var itemColumn = arrayListOf("Name","Count","Color","SKU")
    var optionsInput:String? = null
    var itemPerishable = ArrayList<String>()
    var itemNonperishable = ArrayList<String>()
    var count = 0
    var column = 0
    var count2 = 0
    var column2 = 0

    println("Grocery Inventory System")
    println("- Add Grocery Item")
    println("- Add Grocery Item Info")
    println("- Check Grocery Item List")

    while(true) {
        println("Enter item name: ")
        itemName = readLine().toString()
        println("Enter item category (perishable/nonperishable): ")
        itemCategory = readLine().toString()
        println("Adding item to inventory list...")

        // add info to inventory list
        if(itemCategory == "perishable"){
            itemPerishable.add(itemName)
            itemPerishable.add("1")
            itemPerishable.add("N/A")
            itemPerishable.add("N/A")
        }else{
            itemNonperishable.add(itemName)
            itemNonperishable.add("1")
            itemNonperishable.add("N/A")
            itemNonperishable.add("N/A")
        }
        println("Item added to grocery inventory list.")
        println("Do you want to add another grocery item? (Y/N): ")
        optionsInput = readLine().toString()
        if(optionsInput == "N" || optionsInput == "n"){
            break
        }
    }

    println("Do you want to add grocery item characteristics? (Y/N): ")
    optionsInput = readLine().toString()

    if(optionsInput == "Y" || optionsInput == "y"){
        println("Enter item name to add info: ")
        itemName = readLine().toString()
        if(itemPerishable.contains(itemName)) {
            println("Found $itemName on perishable list.")
            println("Add Item count: ")
            itemCount = readLine()!!.toInt()
            println("Add Item Color: ")
            itemColor = readLine().toString()
            println("Add Item SKU: ")
            itemSKU = readLine()!!.toLong()
            println("Adding new info...")
            var index = itemPerishable.indexOf(itemName)
            itemPerishable.set(index + 1, itemCount.toString())
            itemPerishable.set(index + 2, itemColor)
            itemPerishable.set(index + 3, itemSKU.toString())
        }else if(itemNonperishable.contains(itemName)){
            println("Found $itemName on nonperishable list.")
            println("Add Item count: ")
            itemCount = readLine()!!.toInt()
            println("Add Item Color: ")
            itemColor = readLine().toString()
            println("Add Item SKU: ")
            itemSKU = readLine()!!.toLong()
            println("Adding new info...")
            var index = itemPerishable.indexOf(itemName)
            itemNonperishable.set(index + 1, itemCount.toString())
            itemNonperishable.set(index + 2, itemColor)
            itemNonperishable.set(index + 3, itemSKU.toString())
        }else{
            println("Item name not found.")
        }
    }
    println("Do you want to check grocery list? (Y/N): ")
    optionsInput = readLine().toString()
    if(optionsInput == "Y" || optionsInput == "y"){
        println("Grocery List By Category:")
        println("Perishable:")
        do{
            println("${itemColumn[column]}: ${itemPerishable[count]}")
            ++ count
            ++ column
            if(column == 3){
                column -= 3
                println(" ")
            }
        }while(count < itemPerishable.size)
        println("Non-Perishable:")
        do{
            println("${itemColumn[column2]}: ${itemNonperishable[count2]}")
            ++ count2
            ++ column2
            if(column2 == 3){
                column2 -= 3
                println(" ")
            }
        }while(count2 < itemNonperishable.size)
    }
}