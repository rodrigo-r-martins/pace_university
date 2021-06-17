"""
In this example we focus on setting up a good framework for running data mining procedures. The key concepts introduced in this example are:
1) Estimators
2) Transformers
3) Pipelines

To do this we will use the dataset Ionosphere. The aim of this application is to build a data mining classifier that can determine whether an image is good or bad according to the dataset.
"""

# CHECKING HOME FOLDER
import os
print('===== CHECKING HOME FOLDER =====')
print(os.path.expanduser("~"))
print('')


# TO START WITH, WE LOAD UP THE NUMPY AND CSV LIBRARIES THAT WE WILL NEED FOR THE CODE
import numpy as np
import csv
print('===== PRINTING DATASET PATH =====')
data_filename = "ionosphere.data"      # data file path
print(data_filename)
print('')


# CREATING X AND Y NUMPY ARRAYS TO STORE DATASET IN
x = np.zeros((351, 34), dtype='float')
y = np.zeros((351,), dtype='bool')


# USING CSV MODULE TO LOAD THE FILE
# IMPORT IT AND SET UP A CSV READER OBJECT, THEN LOOP THROUGH THE FILE
# THEN SET THE ROW IN X AND CLASS VALUE IN Y FOR EVERY LINE IN THE DATASET
with open(data_filename, 'r') as input_file:
    reader = csv.reader(input_file)
    for i, row in enumerate(reader):
        # Get the data, converting each item to a float
        data = [float(datum) for datum in row[:-1]]
        # Set the appropriate row in our dataset
        x[i] = data
        # 1 if the class is 'g', 0 otherwise
        y[i] = row[-1] == 'g'


# CREATING TRAINING AND TESTING SETS
from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(x, y, random_state=14)


# CHECKING THE SHAPE OF SETS
print('===== CHECKING THE SHAPE OF SETS =====')
print(f'There are {x_train.shape[0]} samples in the training set')
print(f'There are {x_train.shape[1]} features in the training set')
print(f'There are {x_test.shape[0]} samples in the testing set')
print(f'There are {x_test.shape[1]} features in the testing set')
print('')


# THEN IMPORT THE NEAREST NEIGHBOR CLASS AND CREATE AN INSTANCE FOR IT
# PARAMETERS AS DEFAULTS FOR NOW
# BY DEFAULT, ALGORITHM WILL CHOOSE THE FIVE NEAREST NEIGHBORS TO PREDICT THE CLASS OF A TESTING SAMPLE
from sklearn.neighbors import KNeighborsClassifier
estimator = KNeighborsClassifier()


# AFTER CREATING THE ESTIMATOR, WE MUST FIT IT IN OUR TRAINING DATASET
estimator.fit(x_train, y_train)


# THEN WE TRAIN THE ALGORITHM WITH OUR TEST SET AND EVALUATE WITH OUR TESTING SET
y_predicted = estimator.predict(x_test)
accuracy = np.mean(y_test == y_predicted) * 100
print('===== GETTING ACCURACY OF TESTING SET =====')
print(f'The accuracy is {accuracy:.1f}%')
print('')


# THE SCIKIT-LEARN LIBRARY CONTAINS A FEW CROSS-FOLD VALIDATION METHODS
from sklearn.model_selection import cross_val_score

# USING THIS NEW FUNCTION TO EVALUATE OUR MODEL USING CROSS-FOLD VALIDATION
scores = cross_val_score(estimator, x, y, scoring='accuracy')
average_accuracy = np.mean(scores) * 100
print('===== GETTING ACCURACY OF MODEL USING CROSS-FOLD VALIDATION =====')
print(f'The average accuracy is {average_accuracy:.1f}%')
print('')


# INVESTIGATING THE IMPACT OF PARAMETER ON PERFORMANCE BY TESTING A NUMBER OF VALUES FOR THE N_NEIGHBORS PARAMETER
avg_scores = []
all_scores = []
parameter_values = list(range(1, 21))    # 20 is included
for n_neighbors in parameter_values:
    estimator = KNeighborsClassifier(n_neighbors=n_neighbors)
    scores = cross_val_score(estimator, x, y, scoring='accuracy')
    avg_scores.append(np.mean(scores))
    all_scores.append(scores)


# PLOTTING THE RELATIONSHIP BETWEEN THE VALUE OF N_NEIGHBORS AND THE ACCURACY
from matplotlib import pyplot as plt
plt.plot(parameter_values, avg_scores, '-o')
plt.show()


# TESTING 100 PARAMETER_VALUES TO CHECK VARIANCE
new_avg_scores = []
new_all_scores = []
new_parameter_values = list(range(1, 101))    # 100 is included
for n_neighbors in new_parameter_values:
    estimator = KNeighborsClassifier(n_neighbors=n_neighbors)
    new_scores = cross_val_score(estimator, x, y, scoring='accuracy')
    new_avg_scores.append(np.mean(new_scores))
    new_all_scores.append(new_scores)

# PLOTTING NEW PARAMETER VALUES ALONGSIDE AVERAGE SCORES
plt.plot(new_parameter_values, new_avg_scores, '-o')
plt.show()


# DEALING WITH FEATURES PROBLEM IN RANGE THROUGH BREAKING DATASET
# FIRST WE CREATE A COPY OF THE ARRAY SO WE DON'T ALTER THE ORIGINAL ONE
x_broken = np.array(x)

# NEXT WE BREAK THE DATASET BY DIVIDING EVERY SECOND FEATURE BY 10
x_broken[:,::2] /= 10

# CHECKING THE EFFECT OF THAT BY COMPUTING THE ACCURACY
print('===== CHECKING EFFECT OF BREAKING DATASET =====')
estimator = KNeighborsClassifier()
original_scores = cross_val_score(estimator, x, y, scoring='accuracy')
print(f'The original average accuracy for is {np.mean(original_scores)*100:.1f}%')
broken_scores = cross_val_score(estimator, x_broken, y, scoring='accuracy')
print(f'The \'broken\' average accuracy for is {np.mean(broken_scores)*100:.1f}%')
print('')


# PRE-PROCESSING FEATURE-BASED NORMALIZATION
from sklearn.preprocessing import MinMaxScaler

# RUNNING THE TRANSFORM FUNCTION TO PRE-PROCESSOR
x_transformed = MinMaxScaler().fit_transform(x)
# x_transformed will have same shape as x yet each column will have a max of 1 and min of 0
print('===== CHECKING X_TRANSFORMED DATASET =====')
print(x_transformed)
print('')

# CREATING A WORKFLOW BY COMBINING THE CODE FROM PREVIOUS SECTIONS
x_transformed = MinMaxScaler().fit_transform(x_broken)
estimator = KNeighborsClassifier()
transformed_scores = cross_val_score(estimator, x_transformed, y, scoring='accuracy')
print('===== GETTING ACCURACY OF TRANSFORMED DATASET =====')
print(f'The average accuracy for is {np.mean(transformed_scores)*100:.1f}%')
print('')


# USING PIPELINES TO EXPECT AN ESTIMATOR
from sklearn.pipeline import Pipeline
scaling_pipeline = Pipeline([('scale', MinMaxScaler()), ('predict', KNeighborsClassifier())])

# TESTING PIPELINE USING CROSS-VALIDATION CODE FROM BEFORE
scores = cross_val_score(scaling_pipeline, x_broken, y, scoring='accuracy')
print('===== GETTING ACCURACY USING PIPELINE =====')
print(f'The pipeline scored an average accuracy for is {np.mean(transformed_scores)*100:.1f}%')
print('')