 function editItem(itemId) {
        // Implement the logic to edit the item
        // Implement the logic to delete the item
        fetch(`/api/todolist/${itemId}`,{method:'DELETE'}).then(response => {
            if (response.ok) {
                window.location.reload();
            } else {
                alert('Error Updating item');
            }
        });
    }

    function deleteItem(itemId) {
        // Implement the logic to delete the item
        fetch(`/api/todolist/${itemId}`,{method:'DELETE'}).then(response => {
            if (response.ok) {
                window.location.reload();
            } else {
                alert('Error deleting item');
            }
        });
    }