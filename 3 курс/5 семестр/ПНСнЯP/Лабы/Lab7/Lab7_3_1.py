from keras.models import model_from_json
import numpy as np
from keras.preprocessing import image

json_file = open("mnist_model.json", "r")
loaded_model_json = json_file.read()
json_file.close()
loaded_model = model_from_json(loaded_model_json)
loaded_model.load_weights("mnist_model.h5")
loaded_model.compile(loss='categorical_crossentropy', optimizer='sgd', metrics=['accuracy'])
print("Загрузили Model")

img_path = '6.jpg'
img = image.load_img(img_path, target_size=(28, 28))

x = image.img_to_array(img)
x /= 255
x = x.reshape(-1, 28, 28, 1)[0].reshape(-1, 28, 28, 1)

prediction = loaded_model.predict(x)
# Для удобства вывода задаем список с названиями классов объектов:

classes = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0']
# Печатаем результат распознавания:
print("Результат распознавания: " + classes[np.argmax(prediction)])
